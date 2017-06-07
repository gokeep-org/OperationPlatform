package com.op.customer.action.factory;

import com.op.customer.action.product.CreateProductAction;
import com.op.customer.action.product.DeleteProductByIdAction;
import com.op.customer.action.product.SearchProductByIdAction;
import com.op.customer.action.product.SearchProductByPagingAction;
import com.op.customer.action.product.UpdateProductAction;
import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Product;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class ProductActionFactory extends BaseActionFactory {
    public static CreateProductAction getCreateProductAction(Product product) {
        return new CreateProductAction(product);
    }

    public static DeleteProductByIdAction getDeleteProductByIdAction(String productId) {
        return new DeleteProductByIdAction(productId);
    }

    public static UpdateProductAction getUpdateProductAction(String productId, Product product) {
        return new UpdateProductAction(productId, product);
    }

    public static SearchProductByIdAction getSearchProductByIdAction(String productId) {
        return new SearchProductByIdAction(productId);
    }

    public static SearchProductByPagingAction getSearchProductByPagingAction(SearchInput input, Paging paging) {
        return new SearchProductByPagingAction(input, paging);
    }
}
