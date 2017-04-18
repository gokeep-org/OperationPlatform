import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.core.CoreServerBootstrap;
import com.op.core.bean.entity.User;
import com.op.core.bean.repository.UserRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoreServerBootstrap.class)
public class MongoDbRepositoryTest {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public MongoTemplate mongoTemplate;
    public static User userTemplate;

    static {
        userTemplate = new User();
        String[] strs = {"1111", "222", "3333"};

        userTemplate.setAppIds(
                Arrays.asList(strs)
        );
        userTemplate.setAddress("中国山东济南市历下区");
        userTemplate.setName("帅宁");
        userTemplate.setAge("18");
        userTemplate.setEmail("1748373312@qq.com");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDbRepositoryTest.class);

    @Before
    public void setUp() {
        //userRepository.deleteAll();
    }

    @Test
    public void testInsert() {
        userRepository.insert(userTemplate);
    }


    @Test
    public void testDeleteById() {
        userRepository.delete("aaaaaaaa");
    }

    @Test
    public void testDelete() {
        User user = new User();
        userRepository.delete(user);
    }

    @Test
    public void testDeletes() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        list.add(user1);
        list.add(user2);
        userRepository.delete(list);
    }

    @Test
    public void testUpdate() {
        User user = new User();
//        User monifyUser = userRepository.findOne(user.getId());
//        monifyUser.setUsername(user.getUsername());
//        monifyUser.setId(user.getId());
//        User user1 =userRepository.save(monifyUser);
//        LOGGER.info("user: "+user1);
    }

    @Test
    public void testSearchById() {
        User user = userRepository.findOne("72cfdd79-dca6-4206-80cf-adf82d327704");
        LOGGER.info("user: " + user.toString());
    }

    @Test
    public void testSearchByObj() {
        User user = new User();
//        user.setId("72cfdd79-dca6-4206-80cf-adf82d327704");
        LOGGER.info("user is: " + user.toString());
    }

    @Test
    public void testSearchAll() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            LOGGER.info("user: " + user.toString());
        });
    }

    @Test
    public void testSearchByUsername() {
//        List<User> users = userRepository.findByUsername("xxxxx");
//        users.forEach(user -> {
//            LOGGER.info("user: " + user.toString());
//        });
    }

    @Test
    public void testSearchSize() {
        LOGGER.info("count : " + userRepository.count());
    }
}
