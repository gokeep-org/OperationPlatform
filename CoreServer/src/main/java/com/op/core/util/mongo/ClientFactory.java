package com.op.core.util.mongo;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public class ClientFactory {
    public static com.mongodb.MongoClient getMongoClient(){
        return MongoUtil.getMongoClient();
    }
}
