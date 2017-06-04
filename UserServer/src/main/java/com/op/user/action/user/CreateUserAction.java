package com.op.user.action.user;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.LogMessage;
import com.op.user.bean.entity.user.User;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;
import com.op.util.security.Md5;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class CreateUserAction extends ItemAction<BaseOutput> {
    private User user;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserAction.class);

    public CreateUserAction(User user) {
        this.user = user;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.user)) {
            throw new OperationPlatformException("user is must not null");
        }
        if (null == user.getUsername()) {
            throw new OperationPlatformException("username is must not null");
        }
        if (null == user.getActivated()) {
            user.setActivated(true);
        }
        if (null == user.getStatus()) {
            user.setStatus(true);
        }
        if (null == user.getPassword()){
            user.setPassword(UUID.randomUUID().toString().substring(6));
            LOGGER.info(user.getPassword());
        }
        //优化字符串
        String commonId = UUID.randomUUID().toString().replace("-", "");
        user.setId(commonId);
        user.setUserId(commonId);
        user.setCreateDate(new Date().getTime());
        user.setPassword(Md5.getSercretKey(user.getPassword()));
    }

    @Override
    protected void start() throws Exception {
        //TODO: 需要校验要添加的用户是不是已经存在
        Boolean syncRes = userService.syncUserToMysql(user);
        user.setPassword(null);
        if (syncRes)
            userService.createOneUser(user);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return new ResultMessage();
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.CREATE_USER_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.CREATE_USER_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
