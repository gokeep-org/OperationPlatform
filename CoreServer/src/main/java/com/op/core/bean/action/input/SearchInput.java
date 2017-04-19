package com.op.core.bean.action.input;

import java.util.Map;

import org.springframework.data.mongodb.core.query.Query;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/18.
 ****************************************/
public class SearchInput extends BaseInput{
    @SerializedName("type")
    private String collectionName;
    @SerializedName("id")
    private String id;
    private Map<String, Object> term;
    private String logic;
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public Map<String, Object> getTerm() {
        return term;
    }

    public void setTerm(Map<String, Object> term) {
        this.term = term;
    }


    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    private Object o;

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
