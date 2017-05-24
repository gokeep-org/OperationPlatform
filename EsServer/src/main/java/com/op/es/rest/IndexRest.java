package com.op.es.rest;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.op.es.bean.action.output.index.WriteOutput;
import com.op.es.service.IndexService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-14
 ****************************************/
@Path("/index")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class IndexRest {
    @Autowired
    private IndexService indexService;
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexRest.class);

    /**
     * 创建文档
     * @param index
     * @param type
     * @return
     */
    @POST
    @Path("/{index}/type/{type}")
    public WriteOutput createDocument(@PathParam("index") String index,
                                      @PathParam("type") String type,
                                      Map<String, Object> map) throws IOException {
        WriteOutput output = new WriteOutput(200, "操作成功");
        if (indexService.insertIndex(index, type, UUID.randomUUID().toString(), map)) {
            output.setSuccess("true");
            return output;
        }
        output.setCode(500);
        output.setMessage("操作失败");
        output.setUuid(UUID.randomUUID().toString());
        return output;
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
    public WriteOutput deleteDocumentById(@PathParam("index") String index,
                                          @PathParam("type") String type,
                                          @PathParam("id") String id) {
        WriteOutput output = new WriteOutput(200, "操作成功");
        if (indexService.deleteIndexById(index, type, id)) {
            output.setSuccess("true");
            return output;
        }
        output.setCode(500);
        output.setMessage("操作失败");
        output.setUuid(UUID.randomUUID().toString());
        return output;
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
    public WriteOutput updateDocumentById(@PathParam("index") String index,
                                          @PathParam("type") String type,
                                          @PathParam("id") String id,
                                          Map<String, Object> body) {
        WriteOutput output = new WriteOutput(200, "操作成功");
        if (indexService.updateIndex(index, type, id, body)) {
            output.setSuccess("true");
            return output;
        }
        output.setCode(500);
        output.setMessage("操作失败");
        output.setUuid(UUID.randomUUID().toString());
        return output;
    }

    public IndexService getIndexService() {
        return indexService;
    }

    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }
}
