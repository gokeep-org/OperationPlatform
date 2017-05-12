package com.op.oauth.action.token;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.token.CheckTokenInput;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.token.CheckTokenOutput;
import com.op.oauth.bean.entity.Token;
import com.op.oauth.exception.ErrorCode;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-5
 ****************************************/
public class CheckTokenAction extends ItemAction<BaseOutput> {
    private Token token;
    private List<Token> permissionToken;
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckTokenAction.class);

    public CheckTokenAction(CheckTokenInput input) {
        this.token = new Token();
        this.token.setAccessToken(input.getAccessToken());
        this.token.setUserId(input.getUserId());
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
    }

    @Override
    protected void start() throws Exception {

        permissionToken = tokenService.checkToken(token);
        //获取权限信息
        if (permissionToken.size() != 1) {
            throw new OperationPlatformException(ErrorCode.CHECK_ACCESS_TOKEN_FAILED);
        }
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        CheckTokenOutput output = new CheckTokenOutput();
        output.setToken(permissionToken.get(0));
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("token check is successful");
    }
}
