package com.op.core.service;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
public interface WriteService<O> {
    public Boolean insert(O o, String collectionName);

    public Boolean inserts(Iterable<O> os, String collectionName);

    public Boolean delete(String id, String collectionName);

    public Boolean deletes(List<String> ids, String collectionName);

    public Boolean deleteByQuery(Query query, String collectionName);

    public Boolean update(O o, String collectionName);

    public Boolean updateByQuery(Query query, String collectionName);

    public Boolean updates(Iterable<O> os, String collectionName);

}
