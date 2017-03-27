package com.op.core.action.dao;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/

/**
 * 基本Dao抽象接口
 * @param <T>
 */
public interface BaseDao<T> {
    public void insert(T o);

    public void inserts(Iterable<T> os, Class<T> classes);

    public void delete(T o);

    public void deleteById(String id, Class classes);

    public void deletesByIds(Iterable<String> ids, Class classes);

    public void update(T o);

    public T findOneById(String id, Class classes);

    public long size(T o, Class classes);

    public Iterable<T> finds(T o);
}