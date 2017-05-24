import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.op.es.action.factory.EsClientFactory;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/24.
 ****************************************/

public class JestTest {

    public JestClient jestClient;

    @Before
    public void beafore() {
        jestClient = EsClientFactory.getEsClient();
    }

    @Test
    public void test() {
        System.out.println("j");
    }

    /**
     * 索引一个文档
     * @throws IOException
     */
    @Test
    public void testSimple() throws IOException {
        // 增加一个索引
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bb", "333");
        Index index = new Index
                .Builder(map)
                .index("test")
                .type("aaa")
                .id(UUID.randomUUID().toString())
                .build();
        jestClient.execute(index);
        jestClient.shutdownClient();
    }

    @Test
    public void testDeleteDocument() throws IOException {
        jestClient.execute(new Delete.Builder("467d294a-1af8-49f9-a960-21edb6720f24")
                .index("test")
                .type("aaa")
                .build());
    }

    @Test
    public void testUpdateDocument() {

    }

    @Test
    public void testSearchDocumentById() throws IOException {
        Get get = new Get
                .Builder("test", "7fcde21d-4ce9-42f8-98df-5b9fc6835637")
                .type("aaa")
                .build();

        JestResult result = jestClient.execute(get);
        System.out.println(result.getJsonString());
    }
}
