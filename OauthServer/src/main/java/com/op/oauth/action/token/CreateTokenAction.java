package com.op.oauth.action.token;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.token.CreateTokenInput;
import com.op.oauth.bean.action.input.token.GrantType;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.HttpStatusCode;
import com.op.oauth.bean.action.output.ResultOutput;
import com.op.oauth.bean.action.output.token.CreateTokenOutput;
import com.op.oauth.bean.entity.Token;
import com.op.oauth.bean.entity.User;
import com.op.oauth.util.OpUtils;
import com.op.util.bean.log.MessageLog;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/3.
 ****************************************/
public class CreateTokenAction extends ItemAction<BaseOutput> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTokenAction.class);
    private CreateTokenInput createTokenInput;
    private ResultOutput errorOutput;
    private Token token = new Token();
    private User user = new User();

    public CreateTokenAction(CreateTokenInput input) {
        this.createTokenInput = input;
        this.user.setUsername(input.getUserName());
        this.user.setPassword(input.getPassword());
    }

    @Override
    protected void permissionValidate() throws Exception {
        try{
            if (this.createTokenInput.getGrantType().equals(GrantType.PASSWORD)) {
                List<User> users = userService.checkUserIsLogin(this.user);
                if (users.size() >= 1) {
                    this.user = users.get(0);
                } else {
                    throw new OperationPlatformException("username or password is invalid");
                }
            } else if (this.createTokenInput.getGrantType().equals(GrantType.AUTH_CODE)) {
                //授权码模式，暂时不实现,无需求
                LOGGER.error("auth code mode is not implement");
                throw new OperationPlatformException("no support auth code mode");
            } else {
                throw new OperationPlatformException("grant type is null");
            }
        }catch (Throwable ex){
            LOGGER.info("get user info by username and password is null or error");
            MessageLog messageLog = new MessageLog();
            try {
                if (!Objects.equals(null, this.user) && null != this.user.getUserId())
                    //TODO: 临时测试
                    messageLog.setLoginLog(this.user.getUserId(), false);
                else
                    messageLog.setLoginLog(this.user.getUserId(), false);
                commonService.pushLogMessage(messageLog);
            } catch (Exception exception) {
                LOGGER.error("push user login message found fail");
            }
            throw new OperationPlatformException("username or password is invalid");
        }

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (OpUtils.checkObjectIsNull(this.createTokenInput)) {
            throw new OperationPlatformException("create token object is null");
        }
    }

    @Override
    protected void start() throws Exception {
        try{
            if (this.createTokenInput.getGrantType().equals(GrantType.PASSWORD)) {
                //如果用户的token没有过期，返回当前用户的token
                //如果已经过期，创建一个新的token
                this.token = (Token) tokenService.createTokenByUserId(this.user.getUserId());
                tokenService.setCookie(token);
                LOGGER.info("User login success set cookie is successful");
            } else if (this.createTokenInput.getGrantType().equals(GrantType.AUTH_CODE)) {
                LOGGER.error("password mode is not implement");
            } else {
                throw new OperationPlatformException("grant type is null");
            }
        }catch (Throwable e){
            LOGGER.error("user login is fail");
            //推送
            MessageLog messageLog = new MessageLog();
            try {
                if (!Objects.equals(null, this.user) && null != this.user.getUserId())
                    //TODO: 临时测试
                    messageLog.setLoginLog(this.user.getUserId(), false);
                else
                    messageLog.setLoginLog(this.user.getUserId(), false);
                commonService.pushLogMessage(messageLog);
            } catch (Exception exception) {
                LOGGER.error("push user login message found fail");
            }
            throw new OperationPlatformException("user login is fail get token");
        }

    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        if (OpUtils.checkObjectIsNull(this.token)) {
            this.errorOutput = new ResultOutput();
            errorOutput.setCode(HttpStatusCode.SERVER_ERROR);
            errorOutput.setSuccess(false);
            errorOutput.setMesssage("not get token info");
            return errorOutput;
        }
        CreateTokenOutput output = new CreateTokenOutput();
        output.setToken(this.token);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("create token info by" + this.createTokenInput.getGrantType());
        MessageLog messageLog = new MessageLog();
        try {
            if (!Objects.equals(null, this.user) && null != this.user.getUserId())
                //TODO: 临时测试
                messageLog.setLoginLog(this.user.getUserId(), true);
            else
                messageLog.setLoginLog(this.user.getUserId(), false);
            commonService.pushLogMessage(messageLog);
        } catch (Exception e) {
            LOGGER.error("push user login message found fail");
        }
    }
}
