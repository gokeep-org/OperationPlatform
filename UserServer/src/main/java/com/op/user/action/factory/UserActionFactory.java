package com.op.user.action.factory;

import com.op.user.action.BaseActionFactory;
import com.op.user.action.user.CreateUserAction;
import com.op.user.action.user.DeleteUserAction;
import com.op.user.action.user.SearchUserAction;
import com.op.user.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class UserActionFactory extends BaseActionFactory {
    public static CreateUserAction getCreateUserAction(User user){
        return new CreateUserAction(user);
    }

    public static DeleteUserAction getDeleteUserAction(String userId){
        return new DeleteUserAction(userId);
    }

    public static SearchUserAction getSearchUserAction(String userId, User user){
        return new SearchUserAction(userId, user);
    }
}
