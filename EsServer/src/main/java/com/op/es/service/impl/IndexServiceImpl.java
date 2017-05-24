package com.op.es.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.op.es.action.factory.EsClientFactory;
import com.op.es.bean.action.input.SearchInput;
import com.op.es.config.EsConfig;
import com.op.es.service.IndexService;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
//TODO: 对失败要添加异常处理
@Component
public class IndexServiceImpl implements IndexService {
    @Autowired
    private Requests requests;
    private JestClient client = EsClientFactory.getEsClient();

    /**
     * 索引文档
     * @param index
     * @param type
     * @param id
     * @param body
     * @return
     */
    @Override
    public Boolean insertIndex(String index, String type, String id, Object body) {
        try {
            Index indexer = new Index
                    .Builder(body)
                    .index(index)
                    .type(type)
                    .id(id)
                    .build();
            client.execute(indexer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 更新指定文档
     * 由于jedis无法实现，使用request的方式实现
     * @param index
     * @param type
     * @param id
     * @param body
     * @return
     */
    @Override
    public Boolean updateIndex(String index, String type, String id, Object body) {

        try {
            requests.post(EsConfig.mastUri + "/" + index + "/" + type + "/" + id, body, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除指定文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @Override
    public Boolean deleteIndexById(String index, String type, String id) {
        try {
            client.execute(new Delete.Builder(id)
                    .index(index)
                    .type(type)
                    .build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String searchIndexById(String index, String type, String id) {
        try {
            Get get = new Get
                    .Builder(index, id)
                    .type(type)
                    .build();
            JestResult result = client.execute(get);
//            String res = requests.get(EsConfig.mastUri + "/" + index + "/" + type + "/" + id).json();
            return result.getJsonString();
        } catch (Exception e) {
            JsonObject res = new JsonObject();
            res.addProperty("result", false);
            return res.toString();
        }

    }

    @Override
    public String searchIndexByDSL(String index, String type, Map<String, Object> dsl) {
        String query = SerializeUtil.transfromObjectToString(dsl);
        try {
            Search search = new Search.Builder(query)
                    .addIndex(index)
                    .addType(type)
                    .build();
            SearchResult result = client.execute(search);
            return result.getJsonString();
        } catch (Throwable e) {
            return null;
        }
    }

    @Override
    public String searchIndexByWord(String index, String type, Map<String, String> word) {
        try {
            String res = requests.post(EsConfig.mastUri + "/" + index + "/" + type + "/" + "_search", null, word).json();
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
            requests.delete(EsConfig.mastUri + "/" + index + "/" + type + "/" + "_query", query, null).json();
        } catch (Throwable e) {
            return true;
        }
        return false;
    }

    @Override
    public String pagingSearch(String index, String type, long pageNow, long pageSize, String field, String order) {
        SearchInput input = new SearchInput();
        input.setPaging(pageNow, pageSize, field, order);
        String query = SerializeUtil.transfromObjectToString(input);
        try {
            Search search = new Search.Builder(query)
                    .addIndex(index)
                    .addType(type)
                    .build();

            SearchResult result = client.execute(search);
            return result.getJsonString();
//            SearchInput input = new SearchInput();
//            input.setPaging(pageNow, pageSize, field, order);
//            res = requests.post(EsConfig.mastUri + "/" + index + "/" + type + "/" + "_search", input, null).json();
        } catch (Throwable e) {
            return null;
        }
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }
}
