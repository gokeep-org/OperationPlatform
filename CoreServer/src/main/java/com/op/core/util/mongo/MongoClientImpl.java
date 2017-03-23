package com.op.core.util.mongo;

import java.util.List;

import org.bson.Document;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public class MongoClientImpl implements MongoClient {
    private static com.mongodb.MongoClient client = ClientFactory.getMongoClient();
    @Override
    public void insert(Object o) {

    }

    @Override
    public void inserts(List<Object> os) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void deletes(List<Object> os) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void updates(List<Object> os) {

    }

    @Override
    public <T extends Document, R> R searchOne(T document, Class classes) {
        return null;
    }

    @Override
    public <T extends Document> String searchAll(T document) {
        return null;
    }

    @Override
    public <T extends Document> String searchFirst(T document) {
        return null;
    }

    @Override
    public <T extends Document> String getDocumentSize(T document) {
        return null;
    }
}
