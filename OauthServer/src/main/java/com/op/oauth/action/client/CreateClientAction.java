package com.op.oauth.action.client;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.client.CreateClientInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.client.CreateClientOutput;
import com.op.oauth.bean.entity.Client;
import com.op.oauth.util.OpUtils;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class CreateClientAction extends ItemAction<BaseOutput> {
    private Client client;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClientAction.class);

    public CreateClientAction(CreateClientInput input) {
        this.client = input;
    }

    @Override
    protected void permissionValidate() throws Exception {
        //权限验证
    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkObjectIsNull(this.client)) {
            throw new OperationPlatformException("add client is null");
        }
        this.client.setClientId(UUID.randomUUID().toString());
        this.client.setClientSecret(UUID.randomUUID().toString());
        this.client.setState(1L);
        if (OpUtils.checkStringIsNull(this.client.getGrantType())) {
            this.client.setGrantType("password");
        }
        if (OpUtils.checkStringIsNull(this.client.getScope())) {
            this.client.setScope("app");
        }
        this.client.setCreateDate(new Date());
    }

    @Override
    protected void start() throws Exception {
        clientService.createClient(this.client);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        CreateClientOutput output = new CreateClientOutput();
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("add client is successful");
    }
}
