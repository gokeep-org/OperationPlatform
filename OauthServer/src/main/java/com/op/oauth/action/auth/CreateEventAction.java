package com.op.oauth.action.auth;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.ResultOutput;
import com.op.oauth.bean.entity.Event;
import com.op.oauth.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/10.
 ****************************************/
public class CreateEventAction extends ItemAction<BaseOutput> {
    private Event event;
    private Boolean result;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateRuleAction.class);

    public CreateEventAction(Event event) {
        this.event = event;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, this.event))
            throw new OperationPlatformException("create event must event body is not null");
        List<String> ruleIds = this.event.getRuleIds();
        this.event.setRuleIds(ruleIds.stream().filter(ruleId -> {
            JsonObject ruleJson = authService.getRuleById(ruleId);
            if (!Objects.equals(null, ruleJson)&&Objects.equals(true, ruleJson.get("status").getAsBoolean()))
                return true;
            return false;
        }).collect(Collectors.toList()));
        this.event.setId(UUID.randomUUID().toString());
        this.event.setStatus((null == this.event.getStatus()) ? true : this.event.getStatus());

    }

    @Override
    protected void start() throws Exception {
        this.result = authService.createEvent(this.event);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        if (this.result)
            return new ResultOutput();
        ResultOutput output = new ResultOutput();
        output.setSuccess(false);
        output.setMesssage("创建事件规则失败");
        output.setCode("500");
        output.setUuid(UUID.randomUUID().toString());
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("create event is successful");
    }
}
