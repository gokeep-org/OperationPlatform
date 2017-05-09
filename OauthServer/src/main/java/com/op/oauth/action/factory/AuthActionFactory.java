package com.op.oauth.action.factory;

import com.op.oauth.action.BaseActionFactory;
import com.op.oauth.action.auth.CreateRuleAction;
import com.op.oauth.bean.entity.Rule;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/10.
 ****************************************/
public class AuthActionFactory  extends BaseActionFactory {
    public static CreateRuleAction getCreateRuleAction(Rule rule){
        return new CreateRuleAction(rule);
    }
}
