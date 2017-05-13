package com.op.es.rest;

import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.es.bean.action.output.index.WriteOutput;
import com.op.es.bean.action.output.log.WriteLogOutput;
import com.op.es.bean.entity.index.IndexName;
import com.op.es.bean.entity.log.Log;
import com.op.es.service.IndexService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
@Path("/log")
public class LogRest {
    @Autowired
    private IndexService indexService;

    /**
     * 保存一个日志信息到ES
     * @param log
     * @return
     */
    @POST
    public WriteLogOutput saveLog(Log log) {
        WriteLogOutput output = new WriteLogOutput(200, "操作成功");
        log.setId(UUID.randomUUID().toString());
        if (indexService.insertIndex(IndexName.LOG, log.getType(), UUID.randomUUID().toString(), log)) {
            output.setSuccess("true");
            return output;
        }
        output.setCode(500);
        output.setMessage("操作失败");
        output.setUuid(UUID.randomUUID().toString());
        return output;
    }

    /**
     * 删除一个日志信息到ES
     * @return
     */
    @Path("/all")
    @DELETE
    public WriteLogOutput deleteAllLog() {
        WriteLogOutput output = new WriteLogOutput(200, "操作成功");
        if (indexService.deleteAll("log", "info")) {
            output.setSuccess("true");
            return output;
        }
        output.setCode(500);
        output.setMessage("操作失败");
        output.setUuid(UUID.randomUUID().toString());
        return output;
    }

    /**
     * 添加信息到对应的索引
     */
    public WriteOutput comonWrite(){
        return null;
    }
}