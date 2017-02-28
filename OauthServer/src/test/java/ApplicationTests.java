import com.op.oauth.Application;
import com.op.oauth.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {
	@Autowired
	public UserService userService;

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userService.addUser("aaaa", 111);

	}


}
