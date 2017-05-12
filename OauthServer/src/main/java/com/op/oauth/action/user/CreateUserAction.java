package com.op.oauth.action.user;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.user.CreateUserInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.user.CreateUserOutput;
import com.op.oauth.bean.entity.User;
import com.op.oauth.exception.ErrorCode;
import com.op.oauth.util.OpUtils;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public class CreateUserAction extends ItemAction<BaseOutput> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUserAction.class);
    private User user;

    public CreateUserAction(CreateUserInput input) {
        this.user = input;
    }

    @Override
    protected void permissionValidate() throws Exception {
        //添加用户权限验证，1，getUser, 2, 权限
    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkObjectIsNull(user) || OpUtils.checkStringIsNull(user.getUsername())) {
            throw new OperationPlatformException(ErrorCode.USER_IS_NULL);
        }
        if ((Boolean) userService.checkoutUserNameIsExist(user)) {
            throw new OperationPlatformException(ErrorCode.USER_IS_EXIST);
        }
        this.user.setUserId((null == this.user.getUserId()) ? UUID.randomUUID().toString() : this.user.getUserId());
        this.user.setPassword(this.user.getPassword());
        if (null == this.user.getStatus()) {
            this.user.setStatus(true);
        }
        this.user.setCreateDate(new Date());
    }

    @Override
    protected void start() throws Exception {
        userService.createUser(this.user);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        CreateUserOutput output = new CreateUserOutput();
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("create user is successful");
    }
}
