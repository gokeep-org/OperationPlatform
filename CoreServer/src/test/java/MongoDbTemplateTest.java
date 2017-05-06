import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.DB;
import com.op.core.CoreServerBootstrap;
import com.op.core.action.dao.BaseDao;
import com.op.core.bean.entity.User;
import com.op.core.bean.repository.UserRepository;
import com.op.core.service.ReadServices;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoreServerBootstrap.class)
public class MongoDbTemplateTest {
    private String COLLECTION_TYPE = "user";
    @Autowired
    public MongoTemplate mongoTemplate;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public BaseDao baseDao;
    @Autowired
    public Requests requests;
    public static User userTemplate;
    @Autowired
    private ReadServices readServices;

    static {
        userTemplate = new User();
//        userTemplate.setId(UUID.randomUUID().toString());
        userTemplate.setName("xuning");
        userTemplate.setStatus("true");
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(MongoDbTemplateTest.class);

    @Before
    public void deleteAllUser() {
//        userRepository.deleteAll();
    }


    @Test
    public void testGetMetaInfo() {
        DB db = mongoTemplate.getDb();
        LOGGER.info("DB name is: " + db.getName());
        LOGGER.info("Db options is: " + db.getOptions());
    }

    @Test
    public void testSimplaeInsert() {
        mongoTemplate.insert(userTemplate, "user");
    }

    @Test
    public void testSimplaeInserts() {
        ArrayList<User> users = new ArrayList<>();
        users.add(userTemplate);
        users.add(userTemplate);
        mongoTemplate.insert(users, "user");
    }


    @Test
    public void testRemoveByObj() {
        User user = new User();
//        user.setId("bc9344ef-63ca-4ec3-be8a-fe5a9db237ec");
        mongoTemplate.remove(user, "");
    }

    @Test
    public void testRemoveById() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("id").is("735f8cf7-1ff6-4554-99ab-19208c061b1a");
        query.addCriteria(criteria);
        mongoTemplate.remove(query, "user");
    }

    @Test
    public void testUpdateById() {
        Map map = new HashedMap();
        User user = new User();
        user.setAddress("中国中国中国中国");
        user.setId("58f6d844240b162298fcc085");
        user.setAge("qqqqqqqq");
//        map.put("_id", "58f6d844240b162298fcc085");
//        map.put("inter", "meinv");

        mongoTemplate.save(user, "user");
    }
    @Test
    public void testMapUpdate(){
        User user = new User();
        user.setAddress("中国中国中国中国");
        user.setId("58f6d844240b162298fcc085");
        user.setAge("222eeeeeeeeeeeeee222");
//        requests.get("www.baidu.com");
        requests.put("localhost:20001/w/user", user, null);
    }
    @Test
    public void testfindById() {
        User user1 = mongoTemplate.findById("58dcab6d5e7ee317544c0922", User.class);
        LOGGER.info("User name is :" + user1.getName());
    }

    @Test
    public void testFind() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("id").is("854790c9-088a-40cf-ad36-cecc449f8aa7");
        query.addCriteria(criteria);
        List<User> s = mongoTemplate.find(query, User.class);
        System.out.println(s.get(0).getAddress());
    }

    @Test
    public void testReadSize(){
        Long res = (Long) readServices.findCollectionSize("user");
        LOGGER.info("user size is :"+res);
    }

//    @Test
//    public void testFindOne() {
//        //使用query语法
//        Criteria c = new Criteria();
//        c.and("realm_id").is("0acee42f-96d0-43bd-a751-ea6c95407a17");
//        User user = mongoTemplate.findOne(Query.query(c), User.class);
//        LOGGER.info("user info : " + " user name: " + user.getUsername());
//    }
//    @Test
//    public void testInsertList(){
//        User user = new User();
//
//        List<User> users = new ArrayList<>();
//        users.add(user);
//        baseDao.inserts(users, User.class);
//    }
    //TODO: 未通过
//    @Test
//    public void testdeleteByObj(){
//        User user = new User();
//        user.setUsername("name");
//        baseDao.delete(user);
//    }
//
//    @Test
//    public void testdeleteById(){
//        baseDao.deleteById("58d90673b3812e2e600a1084", User.class);
//    }
//
//    @Test
//    public void testUpdate(){
//        User user = new User();
//        user.setId("58d90673b3812e2e600a1084");
//        user.setUsername("aaaa");
//        baseDao.update(user);
//    }

//    Requests requests;
//    @Test
//    public void testRequest() {
//        User user = new User();
//        user.setName("test request");
//        user.setAddress("dcdcd");
//        String res = requests.post("http://localhost:8080/core/w/user", user, null).text();
//        LOGGER.info("add user is success" + res);
//    }
}
