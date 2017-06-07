package com.op.customer.action.factory;

import com.op.customer.action.contract.CreateContractAction;
import com.op.customer.action.contract.DeleteContractByIdAction;
import com.op.customer.action.contract.SearchContractByIdAction;
import com.op.customer.action.contract.SearchContractPagingAction;
import com.op.customer.action.contract.UpdateContractAction;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Contract;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class ContractActionFactory extends BaseActionFactory {
    public static CreateContractAction getCreateContractAction(Contract contract) {
        return new CreateContractAction(contract);
    }

    public static DeleteContractByIdAction getDeleteContractByIdAction(String contractId) {
        return new DeleteContractByIdAction(contractId);
    }

    public static UpdateContractAction getUpdateContractAction(String contractId, Contract contract) {
        return new UpdateContractAction(contractId, contract);
    }

    public static SearchContractByIdAction getSearchContractByIdAction(String contractId) {
        return new SearchContractByIdAction(contractId);
    }

    public static SearchContractPagingAction getSearchContractPagingAction(SearchInput input, Paging paging) {
        return new SearchContractPagingAction(input, paging);
    }
}
