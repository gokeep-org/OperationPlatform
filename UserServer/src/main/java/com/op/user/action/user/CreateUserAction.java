package com.op.user.action.user;

import java.util.Objects;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.ResultMessage;
import com.op.user.bean.entity.user.User;
import com.op.user.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class CreateUserAction extends ItemAction<BaseOutput> {
    private User user;
    public CreateUserAction(User user) {
        this.user = user;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.user)){
            throw new OperationPlatformException("add user is must not null");
        }
    }

    @Override
    protected void start() throws Exception {
        userService.createOneUser(user);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        return new ResultMessage();
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
