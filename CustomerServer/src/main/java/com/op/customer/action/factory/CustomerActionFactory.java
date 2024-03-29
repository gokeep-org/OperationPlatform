package com.op.customer.action.factory;

import com.op.customer.action.customer.CreateCustomerAction;
import com.op.customer.action.customer.DeleteCustomerByCustomerIdAction;
import com.op.customer.action.customer.PagingSearchCustomerAction;
import com.op.customer.action.customer.SearchCustomerByCustomerIdAction;
import com.op.customer.action.customer.SearchCustomerTotalAction;
import com.op.customer.action.customer.UpdateCustomerByCustomerIdAction;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Customer;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/14.
 ****************************************/
public class CustomerActionFactory extends BaseActionFactory {
    public static CreateCustomerAction getCreateCustomerAction(Customer customer) {
        return new CreateCustomerAction(customer);
    }

    public static DeleteCustomerByCustomerIdAction getDeleteCustomerByCustomerIdAction(String customerId) {
        return new DeleteCustomerByCustomerIdAction(customerId);
    }

    public static UpdateCustomerByCustomerIdAction getUpdateCustomerByCustomerIdAction(String customerId, Customer customer) {
        return new UpdateCustomerByCustomerIdAction(customerId, customer);
    }

    public static SearchCustomerByCustomerIdAction getSearchCustomerByCustomerIdAction(String customerId) {
        return new SearchCustomerByCustomerIdAction(customerId);
    }

    public static SearchCustomerTotalAction getSearchCustomerTotalAction(){
        return new SearchCustomerTotalAction();
    }

    public static PagingSearchCustomerAction getPagingSearchCustomerAction(SearchInput input, Paging paging){
        return new PagingSearchCustomerAction(input, paging);
    }
}
