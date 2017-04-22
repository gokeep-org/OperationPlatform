//import java.util.Map;
//import java.util.UUID;
//
//import com.netflix.discovery.converters.Auto;
//import com.op.es.service.IndexService;
//import org.apache.commons.collections.map.HashedMap;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.elasticsearch.core.query.IndexQuery;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.op.es.EsServerBootstrap;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/30.
// ****************************************/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(EsServerBootstrap.class)
//public class TestEs {
//    @Autowired
//    public IndexService indexService;
//
//    @Test
//    public void testSimple() {
//        Log log = new Log();
//        log.setId(UUID.randomUUID().toString());
//        log.setContent("xuning");
//        logRepository.index(log);
//
//    }
//
//    @Test
//    public void setEsTemplate() {
//        IndexQuery query = new IndexQuery();
//        query.setIndexName("log");
//        query.setId(UUID.randomUUID().toString());
//        Map<String, Object> map = new HashedMap();
//        query.setObject(map);
//        esTemplate.index(query);
//
//    }
//    @Test
//    public void testOPeration(){
//        IndexQuery query = new IndexQuery();
//        query.setId(UUID.randomUUID().toString());
//        query.setIndexName("log");
//        query.setType("info");
//        Map<String, Object> map = new HashedMap();
//        map.put("content", "QQQQQQQQQQQQQQQQQQQ");
//        query.setObject(map);
//        elasticsearchOperations.index(query);
//    }
//
//    @Test
//    public void testDelete(){
//        esTemplate.delete(Log.class, "");
//    }
//
//
//}
