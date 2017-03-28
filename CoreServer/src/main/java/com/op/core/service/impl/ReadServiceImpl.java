package com.op.core.service.impl;

import com.op.core.exception.OperationPlatformException;
import com.op.core.service.BaseService;
import com.op.core.service.ReadServices;
import com.op.core.service.ServiceBeanNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Service(ServiceBeanNames.WRITE_SERVICE)
public class ReadServiceImpl extends BaseService implements ReadServices {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Object findOneById(String id, Class classes) {
        try {
           return mongoTemplate.findById(id, classes);
        } catch (Exception e) {
            throw new OperationPlatformException("find by id is error");
        }
    }

    @Override
    public Object findByQuery(Query query, Class classes) {
        try {
            return mongoTemplate.find(query, classes);
        } catch (Exception e) {
            throw new OperationPlatformException("find by query is error");
        }
    }
}
