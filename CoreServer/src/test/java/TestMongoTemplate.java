import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.op.core.bean.entity.user.User;
import com.op.core.bean.repository.UserRepository;
import com.op.core.util.Md5;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoreServerBootstrap.class)
public class TestMongoTemplate {
    private String COLLECTION_TYPE = "user";
    @Autowired
    public MongoTemplate mongoTemplate;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public BaseDao baseDao;
    public static final Logger LOGGER = LoggerFactory.getLogger(TestMongoTemplate.class);

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
        User user = new User();
        user.setUsername("name");
        user.setPassword(Md5.getSercretKey("xuning"));
        user.setRealmId(UUID.randomUUID().toString());
        baseDao.insert(user);
    }

    @Test
    public void testRemoveData() {
        String id = "";
    }

    @Test
    public void testFindOne() {
        //使用query语法
        Criteria c = new Criteria();
        c.and("realm_id").is("0acee42f-96d0-43bd-a751-ea6c95407a17");
        User user = mongoTemplate.findOne(Query.query(c), User.class);
        LOGGER.info("user info : " + " user name: " + user.getUsername());
    }
    @Test
    public void testInsertList(){
        User user = new User();
        user.setUsername("name");
        user.setPassword(Md5.getSercretKey("xuning"));
        user.setRealmId(UUID.randomUUID().toString());
        User user1 = new User();
        user1.setUsername("name");
        user1.setPassword(Md5.getSercretKey("xuning"));
        user1.setRealmId(UUID.randomUUID().toString());
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        baseDao.inserts(users, User.class);
    }
    //TODO: 未通过
    @Test
    public void testdeleteByObj(){
        User user = new User();
        user.setUsername("name");
        baseDao.delete(user);
    }

    @Test
    public void testdeleteById(){
        baseDao.deleteById("58d90673b3812e2e600a1084", User.class);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId("58d90673b3812e2e600a1084");
        user.setUsername("aaaa");
        baseDao.update(user);
    }

}
