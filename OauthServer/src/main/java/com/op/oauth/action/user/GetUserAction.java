package com.op.oauth.action.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.user.GetUserInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.user.GetUserOutput;
import com.op.oauth.bean.entity.User;
import com.op.oauth.util.OpUtils;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public class GetUserAction extends ItemAction<BaseOutput> {
    private String userId;
    private User user;
    private static final Logger LOGGER = LoggerFactory.getLogger(GetUserAction.class);

    public GetUserAction(GetUserInput input) {
        this.userId = input.getId();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkStringIsNull(this.userId)) {
            throw new OperationPlatformException("get user ids is null");
        }
    }

    @Override
    protected void start() throws Exception {
        this.user = (User) userService.getUserById(userId);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        GetUserOutput output = new GetUserOutput();
        this.user.setId(null);
        this.user.setPassword(null);
        output.setUser(this.user);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("查询用户：" + this.userId);
    }
}