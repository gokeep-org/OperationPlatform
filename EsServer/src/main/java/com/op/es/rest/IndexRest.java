package com.op.es.rest;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@Path("/document")
@Produces({MediaType.APPLICATION_JSON})
public class IndexRest {
    /**
     * 创建文档
     * @param index
     * @param type
     * @return
     */
    @POST
    @Path("/{index}/type/{type}")
    public String createDocument(@PathParam("index") String index,
                                 @PathParam("type") String type,
                                 Map<String, Object> map) throws IOException {
//        JestClient client = EsClientFactory.getEsClient();
//        Index indx = new Index
//                .Builder(map)
//                .index(index)
//                .type(type)
//                .id(UUID.randomUUID().toString())
//                .build();
//       JestResult result = client.execute(indx);
//        return result.getJsonString();
        String document_id = UUID.randomUUID().toString();
        return "";
    }

    /**
     * 根据ID删除文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @DELETE
    @Path("/{index}/type/{type}/id/{id}")
    public String deleteDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {

        return null;
    }

    /**
     * 根据ID更新文档
     * @param index
     * @param type
     * @param id
     * @return
     */
    @PUT
    @Path("/{index}/type/{type}/id/{id}")
    public String updateDocumentById(@PathParam("index") String index,
                                     @PathParam("type") String type,
                                     @PathParam("id") String id) {

        return null;
    }
}
