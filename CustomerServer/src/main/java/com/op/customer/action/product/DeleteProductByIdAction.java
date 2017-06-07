package com.op.customer.action.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.customer.action.item.ItemAction;
import com.op.customer.bean.LogMessage;
import com.op.customer.bean.action.output.ResultMessage;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/7.
 ****************************************/
public class DeleteProductByIdAction extends ItemAction<ResultMessage> {
    private String productId;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteProductByIdAction.class);
    public DeleteProductByIdAction(String productId) {
        this.productId = productId;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.productId)
            throw new OperationPlatformException("delete product must id is not null");
    }

    @Override
    protected void start() throws Exception {
        productService.deleteProductById(this.productId);
    }

    @Override
    protected ResultMessage formatOutput() throws Exception {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode("200");
        resultMessage.setSuccess(true);
        resultMessage.setMesssage("delete product is successful");
        return resultMessage;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.DELETE_PRODUCT_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.DELETE_PRODUCT_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}
