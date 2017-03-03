package com.op.oauth.bean.action.output.client;

import com.op.oauth.bean.action.output.item.ItemOutput;
import com.op.oauth.bean.entity.Client;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class GetClientOutput extends ItemOutput{
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
