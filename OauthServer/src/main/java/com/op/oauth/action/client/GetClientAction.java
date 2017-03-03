package com.op.oauth.action.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.client.GetClientInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.client.GetClientOutput;
import com.op.oauth.bean.entity.Client;
import com.op.oauth.exception.OperationPlatformException;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class GetClientAction extends ItemAction<BaseOutput> {
    private String clientId;
    private Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(GetClientAction.class);
    public GetClientAction(GetClientInput input) {
        this.clientId = input.getClientId();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkStringIsNull(this.clientId)){
            throw  new OperationPlatformException("get client client id is null");
        }
    }

    @Override
    protected void start() throws Exception {
        this.client = (Client) clientService.getClientByClientId(this.clientId);
    }

    @Override
    protected GetClientOutput formatOutput() throws Exception {
        GetClientOutput output = new GetClientOutput();
        output.setClient(this.client);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("get client info is successful");
    }
}
