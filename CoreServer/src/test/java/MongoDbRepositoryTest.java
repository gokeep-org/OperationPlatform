//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.op.core.CoreServerBootstrap;
//import com.op.core.bean.entity.user.User;
//import com.op.core.bean.repository.UserRepository;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/23.
// ****************************************/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(CoreServerBootstrap.class)
//public class MongoDbRepositoryTest {
//    @Autowired
//    public UserRepository userRepository;
//    @Autowired
//    public MongoTemplate mongoTemplate;
//
//    public static User userTemplate;
//
//    static {
//        userTemplate = new User();
////        userTemplate.setId(UUID.randomUUID().toString());
////        userTemplate.setUsername("xuning");
////        userTemplate.setPassword(UUID.randomUUID().toString());
////        userTemplate.setRealmId(UUID.randomUUID().toString());
////        userTemplate.setToken(UUID.randomUUID().toString());
//    }
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDbRepositoryTest.class);
//
//    @Before
//    public void setUp() {
//        //userRepository.deleteAll();
//    }
//
//    @Test
//    public void testInsert() {
//        userRepository.insert(userTemplate);
//    }
//
//
//    @Test
//    public void testDeleteById() {
//        userRepository.delete("2355633b-c469-46cc-b0b4-b7c328d52556");
//    }
//
//    @Test
//    public void testDelete() {
//        User user = new User();
//        user.setId("ae73d973-952e-4531-b06f-91cef4451f7e");
//        userRepository.delete(user);
//    }
//
//    @Test
//    public void testDeletes() {
//        List<User> list = new ArrayList<>();
//        User user1 = new User();
//        User user2 = new User();
//        user1.setId("2355633b-c469-46cc-b0b4-b7c328d52556");
//        user2.setId("dd2e6444-f454-4e52-b22d-8f39a7886ec0");
//        list.add(user1);
//        list.add(user2);
//        userRepository.delete(list);
//    }
//
//    @Test
//    public void testUpdate() {
//        User user = new User();
//        user.setId("72cfdd79-dca6-4206-80cf-adf82d327704");
//        user.setUsername("bbb");
//        User monifyUser = userRepository.findOne(user.getId());
//        monifyUser.setUsername(user.getUsername());
//        monifyUser.setId(user.getId());
//        User user1 =userRepository.save(monifyUser);
//        LOGGER.info("user: "+user1);
//    }
//
//    @Test
//    public void testSearchById() {
//        User user = userRepository.findOne("72cfdd79-dca6-4206-80cf-adf82d327704");
//        LOGGER.info("user: " + user.toString());
//    }
//
//    @Test
//    public void testSearchByObj() {
//        User user = new User();
//        user.setId("72cfdd79-dca6-4206-80cf-adf82d327704");
//        LOGGER.info("user is: " + user.toString());
//    }
//
//    @Test
//    public void testSearchAll() {
//        List<User> users = userRepository.findAll();
//        users.forEach(user -> {
//            LOGGER.info("user: " + user.toString());
//        });
//    }
//
//    @Test
//    public void testSearchByUsername() {
//        List<User> users = userRepository.findByUsername("xxxxx");
//        users.forEach(user -> {
//            LOGGER.info("user: " + user.toString());
//        });
//    }
//
//    @Test
//    public void testSearchSize() {
//        LOGGER.info("count : " + userRepository.count());
//    }
//}
