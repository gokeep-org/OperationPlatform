import com.op.core.CoreServerBootstrap;
import com.op.core.bean.User;
import com.op.core.bean.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    @Before
    public void setUp() {
//        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        User user = new User();
//        user.setId(UUID.randomUUID().toString());
//        user.setPassword("wwwww");
        user.setUsername("iiiii");
        
//        mongoTemplate.find()
//        user.setId("046c69c8-3026-49f8-9736-7071d2ca6818");
        // 创建三个User，并验证User总数
//        userRepository.save(user);
//        userRepository.insert(user);
        
//        User s =userRepository.findByUsername("iiiii");
        User s =userRepository.findByUser(user);
//        User s = userRepository.findOne("58d750afc0a16d1ee1bfbd54");
        System.out.println(s.getUsername());
    }

}
