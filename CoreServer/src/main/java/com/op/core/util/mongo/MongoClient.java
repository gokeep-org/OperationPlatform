package com.op.core.util.mongo;

import java.util.List;

import org.bson.Document;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public interface MongoClient {
    public void insert(Object o);

    public void inserts(List<Object> os);

    public void delete(Object o);

    public void deletes(List<Object> os);

    public void update(Object o);

    public void updates(List<Object> os);

    public <T extends Document, R extends Object>  R searchOne(T document, Class classes);

    public <T extends Document> String searchAll(T document);

    public <T extends Document> String searchFirst(T document);

    public <T extends Document> String getDocumentSize(T document);
}
