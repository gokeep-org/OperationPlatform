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
    void insert(Object o);

    void inserts(List<Object> os);

    void delete(Object o);

    void deletes(List<Object> os);

    void update(Object o);

    void updates(List<Object> os);

    <T extends Document, R extends Object> R searchOne(T document, Class classes);

    <T extends Document> String searchAll(T document);

    <T extends Document> String searchFirst(T document);

    <T extends Document> String getDocumentSize(T document);
}
