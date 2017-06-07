package com.op.customer.service;

import java.util.List;

import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Contract;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public interface ContractService {
    /**
     * 创建合同信息
     * @param contract
     * @return
     */
    public Boolean createContract(Contract contract);

    /**
     * 通过customerId删除合同信息
     * @param contractId
     * @return
     */
    public Boolean deleteContractById(String contractId);

    /**
     * 通过客户Id更新信息
     * @param contract
     * @return
     */
    public Boolean updateContractByContractId(String contractId, Contract contract);

    /**
     * 通过Id查询合同信息
     * @param contractId
     * @return
     */
    public Contract searchContractByCustomerId(String contractId);

    /**
     * 分页查询合同列表信息
     * @param input
     * @param paging
     * @return
     */
    public List<Contract> searchContractList(SearchInput input, Paging paging);

    /**
     * 查询合同总数
     * @return
     */
    public long searchContractTotal();

}
