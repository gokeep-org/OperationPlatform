import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.es.EsServerBootstrap;
import com.op.es.bean.Log;
import com.op.es.respoitry.LogRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/30.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EsServerBootstrap.class)
public class TestEs {
    @Autowired
    public LogRepository logRepository;
    @Test
    public void testSimple(){
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setContent("xuning");
        logRepository.index(log);
    }
}
