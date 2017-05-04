package com.op.core.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.core.action.factory.ReadActionFactory;
import com.op.core.bean.action.input.SearchInput;
import com.op.core.bean.action.output.ReadOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/28.
 ****************************************/
@Path("/read")
@Produces({MediaType.APPLICATION_JSON})
public class ReadRest {
    /**
     * 根据文档ID获取是定文档数据
     * @param collectionName
     * @param id
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{type}/{id}")
    public ReadOutput searchDocumentById(@PathParam("type") String collectionName,
                                         @PathParam("id") String id) throws Exception {
        SearchInput input = new SearchInput();
        input.setCollectionName(collectionName);
        input.setId(id);
        return (ReadOutput) ReadActionFactory.getSearchDocumentByIdAction(input).execute();
    }

    /**
     * 查询符合查询条件的文档,支持分页
     * @param input
     * @param collectionName
     * @return
     * @throws Exception
     */
    @POST
    @Path("/{type}")
    public ReadOutput searchDocumentByQuery(SearchInput input,
                                            @PathParam("type") String collectionName,
                                            @QueryParam("page_now") @DefaultValue("1") int pageNow,
                                            @QueryParam("page_size") @DefaultValue("10") int pageSize,
                                            @QueryParam("field") @DefaultValue("id") String field,
                                            @QueryParam("order") @DefaultValue("descend") String order) throws Exception {
        input.setCollectionName(collectionName);

        return (ReadOutput) ReadActionFactory.getSearchDocumentBytermAction(input, pageNow, pageSize, field, order).execute();
    }

    /**
     * 查询集合内文档数目
     * @param collectionNmae
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{type}/size")
    public ReadOutput searchCollectionSize(@PathParam("type") String collectionNmae) throws Exception {
        return (ReadOutput) ReadActionFactory.getSearchCollectionSizeAction(null, collectionNmae).execute();
    }

    /**
     * 查询重复name的文档
     * @param name
     * @param collectionName
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{type}/repeat")
    public ReadOutput searchCollectionRepeatName(@QueryParam("name") String name,
                                                 @PathParam("type") String collectionName) throws Exception {
        return (ReadOutput) ReadActionFactory.getSearchRepeatCollectionNameAction(name, collectionName).execute();
    }


}
