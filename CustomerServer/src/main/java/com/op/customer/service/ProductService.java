package com.op.customer.service;

import java.util.List;

import com.op.customer.bean.action.input.SearchInput;
import com.op.customer.bean.entity.Product;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public interface ProductService {
    /**
     * 创建产品信息
     * @param product
     * @return
     */
    public Boolean createProduct(Product product);

    /**
     * 删除产品信息
     * @param productId
     * @return
     */
    public Boolean deleteProductById(String productId);

    /**
     * 更新产品信息
     * @param productId
     * @param product
     * @return
     */
    public Boolean updateProductById(String productId, Product product);

    /**
     * 根据ID查询产品信息
     * @param productId
     * @return
     */
    public Product searchProductById(String productId);

    /**
     * 分页-排序-过滤-查询产品信息
     * @param paging
     * @param input
     * @return
     */
    public List<Product> searchProdustListByPaging(SearchInput input, Paging paging);

    /**
     * 查询产品总数-不进行过滤
     * @return
     */
    public long searchProductTotal();

    public long searchProductBySearchQueryBosy(Product product);
}
