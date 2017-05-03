package com.op.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.op.core.exception.OperationPlatformException;
import com.op.core.service.BaseService;
import com.op.core.service.ReadServices;
import com.op.core.service.ServiceBeanNames;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Service(value = ServiceBeanNames.READ_SERVICE)
public class ReadServiceImpl extends BaseService implements ReadServices {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Map<String, Object> findOneById(String id, String collectionName) {
        try {
            return mongoTemplate.findById(id, Map.class, collectionName);
        } catch (Exception e) {
            throw new OperationPlatformException("find by id is error");
        }
    }

    @Override
    public List<Map> findByQuery(Query query, String collectionName) {
        try {
            return mongoTemplate.find(query, Map.class,  collectionName);
        } catch (Exception e) {
            throw new OperationPlatformException("find by query is error");
        }
    }

    @Override
    public Long findCollectionSize(String collection) {
        try {
            return mongoTemplate.count(null, collection);
        } catch (Exception e) {
            throw new OperationPlatformException("find collection size is error");
        }
    }

    @Override
    public Object findCollectionSizeByQuery(Query query, String collection) {
        try {
            return mongoTemplate.count(query, collection);
        } catch (Exception e) {
            throw new OperationPlatformException("find collection size by query is error");
        }
    }
}