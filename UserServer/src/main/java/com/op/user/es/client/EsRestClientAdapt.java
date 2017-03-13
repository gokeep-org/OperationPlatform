package com.op.user.es.client;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public interface EsRestClientAdapt {

    public JestClient getEsRestClient();
    public JestResult execute();
    public void closeClient(JestClient client);

}
