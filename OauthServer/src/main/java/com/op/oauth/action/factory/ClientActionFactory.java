package com.op.oauth.action.factory;

import com.op.oauth.action.BaseActionFactory;
import com.op.oauth.action.client.CreateClientAction;
import com.op.oauth.action.client.DeleteClientAction;
import com.op.oauth.action.client.GetClientAction;
import com.op.oauth.action.client.UpdateClientAction;
import com.op.oauth.bean.action.input.client.CreateClientInput;
import com.op.oauth.bean.action.input.client.DeleteClientInput;
import com.op.oauth.bean.action.input.client.GetClientInput;
import com.op.oauth.bean.action.input.client.UpdateClientInput;

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

    public static DeleteClientAction getDeleteClientAction(DeleteClientInput input) {
        return new DeleteClientAction(input);
    }

    public static UpdateClientAction getUpdateClientAction(UpdateClientInput input) {
        return new UpdateClientAction(input);
    }

    public static GetClientAction getClientAction(GetClientInput input) {
        return new GetClientAction(input);
    }
}
