package com.op.customer.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.customer.action.factory.ProductActionFactory;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Product;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductRest {
    /**
     * 添加产品信息
     * @param product
     * @return
     */
    @POST
    public ResultMessage createProduct(Product product) throws Exception {
        return ProductActionFactory.getCreateProductAction(product).execute();
    }

    /**
     * 根据产品ID删除产品信息
     * @param productId
     * @return
     */
    @DELETE
    @Path("/{id}")
    public ResultMessage deleteProductByProductId(@PathParam("id") String productId) throws Exception {
        return ProductActionFactory.getDeleteProductByIdAction(productId).execute();
    }


    /**
     * 根据产品ID更新产品信息
     * @param productId
     * @param product
     * @return
     */
    @PUT
    @Path("/{id}")
    public ResultMessage updateProductByProductId(@PathParam("id") String productId, Product product) throws Exception {
        return ProductActionFactory.getUpdateProductAction(productId, product).execute();
    }

    /**
     * 根据产品ID获取产品信息
     * @param productId
     * @return
     */
    @GET
    @Path("/{id}")
    public SearchOutput searchProductByProductId(@PathParam("id") String productId) throws Exception {
        return ProductActionFactory.getSearchProductByIdAction(productId).execute();
    }

    /**
     * 分页排序查询产品信息
     * @return
     */
    @POST
    @Path("/search")
    public SearchOutput searchProductByPaging(SearchInput input,
                                              @QueryParam("page_now") @DefaultValue("1") int pageNow,
                                              @QueryParam("page_size") @DefaultValue("10") int pageSize,
                                              @QueryParam("field") @DefaultValue("create_time") String field,
                                              @QueryParam("order") @DefaultValue("descend") String order) throws Exception {
        Paging paging = new Paging(pageNow, pageSize, field, order);
        return ProductActionFactory.getSearchProductByPagingAction(input, paging).execute();
    }

}
