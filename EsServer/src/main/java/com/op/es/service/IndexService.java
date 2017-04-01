package com.op.es.service;

import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
public interface IndexService {
    public Boolean insertIndex(String index, String type, String id, Map<String, Object> body);

    public Boolean updateIndex(String index, String type, String id, Map<String, Object> body);

    public Boolean deleteIndexById(String index, String type, String id);

    public String searchIndexById(String index, String type, String id);

    public String searchIndexByDSL(String index, String type, Map<String, Object> dsl);

    public String searchIndexByWord(String index, String type, Map<String, String> word);

}
