package com.op.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.op.core.service.BaseService;
import com.op.core.service.ServiceBeanNames;
import com.op.core.service.WriteService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Service(value = ServiceBeanNames.WRITE_SERVICE)
public class WriteServiceImpl extends BaseService implements WriteService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Boolean insert(Object o, String collectionName) {
        try {
            mongoTemplate.insert(o, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean inserts(Iterable iterable, String collectionName) {
        try {
            iterable.forEach(doc->{
                mongoTemplate.insert(doc, collectionName);
            });

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(String id, String collectionName) {
        try {
            final Query query = new Query();
            query.addCriteria(new Criteria().and("id").is(id));
            mongoTemplate.remove(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteByQuery(Query query, String collectionName) {
        try {
            mongoTemplate.remove(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(Object o, String collectionName) {
        try {
            mongoTemplate.save(o, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateByQuery(Query query, String collectionName) {
        try {
            mongoTemplate.save(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updates(Iterable iterable, String collectionName) {
        try {
            mongoTemplate.save(iterable, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean deletes(List ids, String collectionName) {
        try {
            ids.forEach(id -> {
                final Query query = new Query();
                query.addCriteria(new Criteria().and("id").is(id));
                mongoTemplate.remove(query, collectionName);
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
