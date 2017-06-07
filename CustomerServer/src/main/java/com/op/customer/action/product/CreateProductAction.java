package com.op.customer.action.product;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

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
public class CreateProductAction extends ItemAction<ResultMessage> {
    private Product product;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductAction.class);

    public CreateProductAction(Product product) {
        this.product = product;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.product))
            throw new OperationPlatformException("create product must is not null");
        this.product.setCreateDate(new Date().getTime());
        this.product.setId(UUID.randomUUID().toString());
        this.product.setStatus((null == this.product.getStatus()) ? true : this.product.getStatus());
    }

    @Override
    protected void start() throws Exception {
        productService.createProduct(this.product);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setSuccess(true);
        resultMessage.setMesssage("create product is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.CREATE_PRODUCT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.CREATE_PRODUCT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
