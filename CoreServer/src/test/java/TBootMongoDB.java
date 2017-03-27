import java.util.UUID;

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
import com.op.core.bean.entity.user.User;
import com.op.core.bean.repository.UserRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CoreServerBootstrap.class)
public class TBootMongoDB {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public MongoTemplate mongoTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(TBootMongoDB.class);
    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setUsername("iiiii");
        User s =userRepository.findByUsername("iiiii");
        System.out.println(s.getUsername());
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        user.setRealmId(UUID.randomUUID().toString());
        user.setToken(UUID.randomUUID().toString());
        userRepository.insert(user);
    }

    @Test
    public void testDelete(){
        User user = new User();
        userRepository.delete("58d90237b3812e1f782eb366");
    }

    @Test
    public void testDeleteByObj(){
        User user = new User();
        user.setId("");
        userRepository.delete(user);
    }

}
