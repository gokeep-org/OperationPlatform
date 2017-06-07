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

import com.op.customer.action.factory.ContractActionFactory;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Contract;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
@Path("/contract")
@Produces(MediaType.APPLICATION_JSON)
public class ContractRest {
    /**
     * 创建合同
     * @param contract
     * @return
     */
    @POST
    public ResultMessage createContract(Contract contract) throws Exception {
        return ContractActionFactory.getCreateContractAction(contract).execute();
    }

    /**
     * 根据ID删除合同信息
     * @param contractId
     * @return
     * @throws Exception
     */
    @DELETE
    @Path("/{id}")
    public ResultMessage deleteContractById(@PathParam("id") String contractId) throws Exception {
        return ContractActionFactory.getDeleteContractByIdAction(contractId).execute();
    }

    /**
     * 根据ID更新ID信息
     * @param contractId
     * @param contract
     * @return
     * @throws Exception
     */
    @PUT
    @Path("/{id}")
    public ResultMessage updateContractByContractId(@PathParam("id") String contractId, Contract contract) throws Exception {
        return ContractActionFactory.getUpdateContractAction(contractId, contract).execute();
    }

    /**
     * 根据Id查询合同信息
     * @param contractId
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{id}")
    public SearchOutput searchContractByContractId(@PathParam("id") String contractId) throws Exception {
        return ContractActionFactory.getSearchContractByIdAction(contractId).execute();
    }

    /**
     * 分页查询合同信息
     * @param input
     * @param pageNow
     * @param pageSize
     * @param field
     * @param order
     * @return
     * @throws Exception
     */
    @POST
    @Path("/search")
    public SearchOutput searchContractListPaging(SearchInput input,
                                                 @QueryParam("page_now") @DefaultValue("1") int pageNow,
                                                 @QueryParam("page_size") @DefaultValue("10") int pageSize,
                                                 @QueryParam("field") @DefaultValue("create_time") String field,
                                                 @QueryParam("order") @DefaultValue("descend") String order) throws Exception {
        Paging paging = new Paging(pageNow, pageSize, field, order);
        return ContractActionFactory.getSearchContractPagingAction(input, paging).execute();
    }
}
