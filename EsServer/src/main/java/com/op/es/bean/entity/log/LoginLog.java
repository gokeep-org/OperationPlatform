package com.op.es.bean.entity.log;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/31.
 ****************************************/
@Document(indexName = "log", type = "login")
public class LoginLog {
}
