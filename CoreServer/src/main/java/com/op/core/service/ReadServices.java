package com.op.core.service;

import org.springframework.data.mongodb.core.query.Query;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
public interface ReadServices<T> {
    public T findOneById(String id, String collectionName);

    public T findByQuery(Query query, String collectionName);

    public T findCollectionSize(String collection);

    public T findCollectionSizeByQuery(Query query, String collection);
}