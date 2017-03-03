package com.op.oauth.action.factory;

import com.op.oauth.action.BaseActionFactory;
import com.op.oauth.action.client.CreateClientAction;
import com.op.oauth.bean.action.input.client.CreateClientInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class ClientActionFactory extends BaseActionFactory {
    public static CreateClientAction getCreateClientAction(CreateClientInput input) {
        return new CreateClientAction(input);
    }

}
