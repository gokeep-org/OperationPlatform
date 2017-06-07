package com.op.customer.action.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.customer.bean.entity.Product;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class UpdateProductAction extends ItemAction<ResultMessage> {
    private String productId;
    private Product product;

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProductAction.class);

    public UpdateProductAction(String productId, Product product) {
        this.productId = productId;
        this.product = product;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if(null == this.productId)
            throw  new OperationPlatformException("update product id must is not null");
    }

    @Override
    protected void start() throws Exception {
        productService.updateProductById(this.productId, this.product);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setSuccess(true);
        resultMessage.setMesssage("update product is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.UPDATE_PRODUCT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.UPDATE_PRODUCT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
