package com.op.core.action.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.op.core.action.dao.BaseDao;
import com.op.core.util.mongo.SerializeUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
@Component
public class BaseDaoImpl implements BaseDao {

    @Autowired
    public MongoTemplate mongo;

    @Override
    public void insert(Object o) {
        mongo.insert(
                SerializeUtil.parseToBson(o),
                SerializeUtil.getCollectionNameByClass(o.getClass())
        );
    }

    @Override
    public void inserts(Iterable os, Class classes) {
        os.forEach(o -> {
            mongo.insert(
                    SerializeUtil.parseToBson(o),
                    SerializeUtil.getCollectionNameByClass(classes)
            );
        });

    }

    @Override
    public void delete(Object o) {
        mongo.remove(
                SerializeUtil.parseToBson(o),
                SerializeUtil.getCollectionNameByClass(o.getClass())
        );
    }

    @Override
    public void deleteById(String id, Class classes) {
        mongo.remove(
                id,
                SerializeUtil.getCollectionNameByClass(classes)
        );
    }

    @Override
    public void update(Object o) {
        mongo.save(
                SerializeUtil.parseToBson(o),
                SerializeUtil.getCollectionNameByClass(o.getClass())
        );
    }

    @Override
    public Object findOneById(String id, Class classes) {
        return mongo.findById(id, classes);
    }

    @Override
    public long size(Object o, Class classes) {
        return mongo.findAll(
                classes,
                SerializeUtil.getCollectionNameByClass(o.getClass())
        ).size();
    }

    @Override
    public Iterable finds(Object o) {
        return null;
    }

    @Override
    public void deletesByIds(Iterable ids, Class classes) {
        ids.forEach(id -> {
            mongo.remove(id, SerializeUtil.getCollectionNameByClass(classes));
        });
    }


//    @Autowired
//    public MongoTemplate mongo;
//    public String COLLECTION_NAME;
//
//    public BaseDaoImpl() {
//
//    }
//
//    public BaseDaoImpl(String collectionName) {
//        this.COLLECTION_NAME = collectionName;
//    }
//
//    @Override
//    public void insert(Object o) {
//        o.getClass().getName()
//        mongo.insert(o, COLLECTION_NAME);
//    }
//
//    @Override
//    public void inserts(Iterable os) {
//        mongo.insert(os, COLLECTION_NAME);
//    }
//
//    @Override
//    public void delete(Object o) {
//        mongo.remove(o, COLLECTION_NAME);
//    }
//
//    @Override
//    public void deleteById(String id) {
//        mongo.remove(id, COLLECTION_NAME);
//    }
//
//    @Override
//    public void update(Object o) {
//        mongo.save(o, COLLECTION_NAME);
//    }
//
//    @Override
//    public Object findOneById(String id) {
//        final Criteria criteria = new Criteria();
//        criteria.and("_id").is(id);
//        return mongo.findOne(Query.query(criteria),new Object().getClass());
//    }
//
//    @Override
//    public Iterable finds(Object o) {
//        return null;
//    }
//
//    @Override
//    public void deletesByIds(Iterable ids) {
//        ids.forEach(id -> {
//            mongo.remove(id, COLLECTION_NAME);
//        });
//    }
}
