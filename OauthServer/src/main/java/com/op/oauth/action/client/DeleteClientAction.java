package com.op.oauth.action.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.client.DeleteClientInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.client.DeleteClientOutput;
import com.op.oauth.exception.OperationPlatformException;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class DeleteClientAction extends ItemAction<BaseOutput> {
    private List<String> clientIds;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteClientAction.class);

    public DeleteClientAction(DeleteClientInput input) {
        this.clientIds = input.getClientIds();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkObjectIsNull(clientIds)) {
            throw new OperationPlatformException("delete client client ids is null");
        }
    }

    @Override
    protected void start() throws Exception {
        this.clientIds.forEach(clientId -> {
            try {
                clientService.deleteClient(clientId);
            } catch (Throwable e) {
                LOGGER.error("delete client error, clienr id is:" + clientId);
            }

        });
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        DeleteClientOutput output = new DeleteClientOutput();
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("delete client is successful");
    }
}
