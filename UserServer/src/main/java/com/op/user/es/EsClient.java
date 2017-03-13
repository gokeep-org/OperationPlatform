package com.op.user.es;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public interface EsClient {
    public void createIndex();
    public void updateIndex();
    public void deleteIndex();
    public void searchIndex();
    public void searchDocumentById();
    public void searchDocumentParams();
}
