import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.op.user.bean.entity.user.User;
import com.op.util.requests.Requests;
import com.op.util.requests.core.RequestImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/6.
 ****************************************/
public class UserTest {
    Requests requests = new RequestImpl();

    @Test
    public void batchInsertUser() {
        long count = 100000;

        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setActivated(true);
            user.setStatus(true);
            user.setId(UUID.randomUUID().toString());
            user.setCreateDate(new Date().getTime());
            user.setUsername("xuning_" + i + "");
            user.setAddress("中国山东");
            user.setEmail("1748373312@qq.com");
            user.setPhone("18753377393");
            user.setQq("1748373312");
            user.setRemark("暂时没有备注信息");
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            requests.post("localhost:60001/user/user", user, headers);
        }
    }
}
