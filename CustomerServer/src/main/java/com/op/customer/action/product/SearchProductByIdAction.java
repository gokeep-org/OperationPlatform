package com.op.customer.action.product;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.SearchOutput;
import com.op.customer.bean.entity.Product;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class SearchProductByIdAction extends ItemAction<SearchOutput> {
    private Product product;
    private String productId;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchProductByIdAction.class);

    public SearchProductByIdAction(String productId) {
        this.productId = productId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.productId)
            throw new OperationPlatformException("search product by id must is is not null");
    }

    @Override
    protected void start() throws Exception {
        this.product = productService.searchProductById(this.productId);
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setResult(this.product);
        output.setTotal(Objects.equals(null, this.product) ? 0 : 1);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_PRODUCT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_PRODUCT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
