package com.op.oauth.action.auth;

import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.ResultOutput;
import com.op.oauth.bean.entity.Rule;
import com.op.util.exception.OperationPlatformException;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/10.
 ****************************************/
public class CreateRuleAction extends ItemAction<BaseOutput> {
    private Rule rule;
    private Boolean result;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateRuleAction.class);

    public CreateRuleAction(Rule rule) {
        this.rule = rule;
    }

    @Override
    protected void permissionValidate() throws Exception {
        this.rule.setId(UUID.randomUUID().toString());
        this.rule.setStatus((null == this.rule.getStatus() ? true : this.rule.getStatus()));
    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.rule)) {
            throw new OperationPlatformException("create rule must rule is not null");
        }
    }

    @Override
    protected void start() throws Exception {
        if (authService.createRule(this.rule))
            this.result = true;
        else
            this.result = false;
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        if (this.result)
            return new ResultOutput();
        ResultOutput output = new ResultOutput();
        output.setSuccess(false);
        output.setMesssage("创建访问规则失败");
        output.setCode("500");
        output.setUuid(UUID.randomUUID().toString());
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("create rule is successful");
    }
}
