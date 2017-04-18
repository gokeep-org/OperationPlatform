package com.op.es.respoitry;


import com.op.es.bean.entity.log.Log;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/30.
 ****************************************/
public interface LogRepository extends ElasticsearchRepository<Log, String> {
}
