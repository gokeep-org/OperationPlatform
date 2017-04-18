package com.op.oauth.action.factory;

import com.op.oauth.action.BaseActionFactory;
import com.op.oauth.action.user.CreateUserAction;
import com.op.oauth.action.user.GetUserAction;
import com.op.oauth.bean.action.input.user.CreateUserInput;
import com.op.oauth.bean.action.input.user.GetUserInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public class UserActionFactory extends BaseActionFactory {
    public static CreateUserAction getCreateAction(CreateUserInput input) {
        return new CreateUserAction(input);
    }

    public static GetUserAction getUserAction(GetUserInput input) {
        return new GetUserAction(input);
    }
}
