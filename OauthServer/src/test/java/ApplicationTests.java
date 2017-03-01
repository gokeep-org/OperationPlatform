import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.oauth.Application;
import com.op.oauth.bean.OauthCode;
import com.op.oauth.dao.OauthCodeMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "dev")
public class ApplicationTests {

    @Autowired
    public OauthCodeMapper oauthCodeMapper;

	@Test
	public void testMybatis(){
        OauthCode oauthCode = new OauthCode();
        oauthCode.setCode("sssss");
        oauthCode.setAuthentication("aaa".getBytes());
        oauthCodeMapper.insert(oauthCode);
    }


}
