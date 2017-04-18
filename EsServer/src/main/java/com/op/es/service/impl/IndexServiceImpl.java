package com.op.es.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.op.es.config.EsConfig;
import com.op.es.service.IndexService;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Component
public class IndexServiceImpl implements IndexService {
    @Autowired
    private Requests requests;

    @Override
    public Boolean insertIndex(String index, String type, String id, Object body) {
        try {
            requests.post(EsConfig.esUri + "/" + index + "/" + type + "/" + id, body, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Boolean updateIndex(String index, String type, String id, Object body) {
        try {
            requests.post(EsConfig.esUri + "/" + index + "/" + type + "/" + id, body, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteIndexById(String index, String type, String id) {
        try {
            requests.delete(EsConfig.esUri + "/" + index + "/" + type + "/" + id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String searchIndexById(String index, String type, String id) {
        try {
            String res = requests.get(EsConfig.esUri + "/" + index + "/" + type + "/" + id).json();
            return res;
        } catch (Exception e) {
            JsonObject res = new JsonObject();
            res.addProperty("result", false);
            return res.toString();
        }

    }

    @Override
    public String searchIndexByDSL(String index, String type, Map<String, Object> dsl) {
        try {
            String res = requests.post(EsConfig.esUri + "/" + index + "/" + type + "/" + "_search", dsl, null).json();
            return res;
        } catch (Exception e) {
            JsonObject res = new JsonObject();
            res.addProperty("result", false);
            return res.toString();
        }
    }

    @Override
    public String searchIndexByWord(String index, String type, Map<String, String> word) {
        try {
            String res = requests.post(EsConfig.esUri + "/" + index + "/" + type + "/" + "_search", null, word).json();
            return res;
        } catch (Exception e) {
            JsonObject res = new JsonObject();
            res.addProperty("result", false);
            return res.toString();
        }
    }

    @Override
    public Boolean deleteAll(String index, String type) {
        try {
            JsonObject match = new JsonObject();
            match.add("match_all", new JsonObject());
            JsonObject query = new JsonObject();
            query.add("query", match);
            requests.delete(EsConfig.esUri + "/" + index + "/" + type + "/" + "_query", query, null).json();
        } catch (Throwable e) {
            return true;
        }
        return false;
    }
}
