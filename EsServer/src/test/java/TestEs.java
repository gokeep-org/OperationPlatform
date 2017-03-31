import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.es.EsServerBootstrap;
import com.op.es.bean.Log;
import com.op.es.respoitry.LogRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/30.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EsServerBootstrap.class)
public class TestEs {
    @Autowired
    public LogRepository logRepository;
    @Autowired
    ElasticsearchOperations elasticsearchOperations;
    @Autowired
    public ElasticsearchTemplate esTemplate;

    @Test
    public void testSimple() {
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setContent("xuning");
        logRepository.index(log);
    }

    @Test
    public void setEsTemplate() {
        IndexQuery query = new IndexQuery();
        query.setType("info");
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setContent("CCCCCCCCCCCCCCCCCCCCC");
        query.setObject(log);
        esTemplate.index(query);
    }
    @Test
    public void testOPeration(){
        IndexQuery query = new IndexQuery();
        query.setId(UUID.randomUUID().toString());
        query.setIndexName("log");
        query.setType("info");
        Map<String, Object> map = new HashedMap();
        map.put("content", "QQQQQQQQQQQQQQQQQQQ");
        query.setObject(map);
        elasticsearchOperations.index(query);
    }

    @Test
    public void testDelete(){
        esTemplate.delete(Log.class, "");
    }


}
