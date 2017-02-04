
import com.alibaba.fastjson.JSONObject;
import com.op.App;
import com.op.queue.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/4.
 ****************************************/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class Trabbitmq {
		@Autowired
		private Sender sender;
		@Test
		public void hello() throws Exception {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("type", "customer");
			jsonObject.put("aaa","bbbb");
				sender.send("customer", jsonObject.toJSONString());
		}
}
