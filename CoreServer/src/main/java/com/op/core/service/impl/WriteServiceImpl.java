package com.op.core.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    /**
     * 插入单个对象
     * @param o
     * @param collectionName
     * @return
     */
    @Override
    public Boolean insert(Object o, String collectionName) {
        try {
            mongoTemplate.insert(o, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 插入多个对象
     * @param iterable
     * @param collectionName
     * @return
     */
    @Override
    public Boolean inserts(Iterable iterable, String collectionName) {
        try {
            iterable.forEach(doc -> {
                mongoTemplate.insert(doc, collectionName);
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 删除单个对象
     * @param id
     * @param collectionName
     * @return
     */
    @Override
    public Boolean delete(String id, String collectionName) {
        try {
            final Query query = new Query();
            query.addCriteria(new Criteria().and("_id").is(id));
            mongoTemplate.remove(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 通过Query删除
     * @param query
     * @param collectionName
     * @return
     */
    @Override
    public Boolean deleteByQuery(Query query, String collectionName) {
        try {
            mongoTemplate.remove(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 批量更新对象
     * @param o
     * @param collectionName
     * @return
     */
    @Override
    public Boolean update(Map o, String collectionName) {
        try {
            Iterator<Map.Entry<String, Object>> entries = o.entrySet().iterator();
            Query query = new Query(Criteria.where("_id").is(o.get("id")));
            Update update = new Update();
            for (Iterator<Map.Entry<String, Object>> it = entries; it.hasNext(); ) {
                it.forEachRemaining(e -> {
                    update.set(e.getKey(), e.getValue());
                });
            }
            mongoTemplate.updateMulti(query, update, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateById(String id, Map o, String collectionName) {
        try {
            Iterator<Map.Entry<String, Object>> entries = o.entrySet().iterator();
            Query query = new Query(Criteria.where("_id").is(id));
            Update update = new Update();
            for (Iterator<Map.Entry<String, Object>> it = entries; it.hasNext(); ) {
                it.forEachRemaining(e -> {
                    update.set(e.getKey(), e.getValue());
                });
            }
            mongoTemplate.updateMulti(query, update, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 根据Query更新
     * No Use
     * @param query
     * @param collectionName
     * @return
     */
    @Override
    public Boolean updateByQuery(Query query, String collectionName) {
        try {
            mongoTemplate.save(query, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 批量更新
     * No use
     * @param iterable
     * @param collectionName
     * @return
     */
    @Override
    public Boolean updates(Iterable iterable, String collectionName) {
        try {
            mongoTemplate.save(iterable, collectionName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 批量删除
     * @param ids
     * @param collectionName
     * @return
     */
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
