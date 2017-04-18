package com.op.oauth.action.client;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.client.UpdateClientInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.client.UpdateClientOutput;
import com.op.oauth.bean.entity.Client;
import com.op.oauth.exception.OperationPlatformException;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class UpdateClientAction extends ItemAction<BaseOutput> {
    private Client client;

    public UpdateClientAction(UpdateClientInput input) {
        this.client = input;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkObjectIsNull(this.client)) {
            throw new OperationPlatformException("update client object is null");
        }
        Client exist = (Client) clientService.getClientByClientId(this.client.getClientId());
    }

    @Override
    protected void start() throws Exception {
        clientService.updateClient(this.client);
    }

    @Override
    protected UpdateClientOutput formatOutput() throws Exception {
        return new UpdateClientOutput();
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
