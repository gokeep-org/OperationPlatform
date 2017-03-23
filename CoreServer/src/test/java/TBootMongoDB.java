import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.core.CoreServerBootstrap;
import com.op.core.bean.User;
import com.op.core.bean.UserRepository;

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
    private UserRepository userRepository;

    @Before
    public void setUp() {
//        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setPassword("ningning");
        user.setUsername("aaaaa");
        // 创建三个User，并验证User总数
//        userRepository.save(user);
        User s = userRepository.findByUsername("aaaaa");
        System.out.println(s.getUsername());
    }

}
