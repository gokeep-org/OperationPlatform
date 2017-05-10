package com.op.oauth.action.auth;

import java.util.Objects;

import com.google.gson.JsonObject;
import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.action.output.common.SearchOutput;
import com.op.oauth.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/10.
 ****************************************/
public class GetRuleByIdAction extends ItemAction<BaseOutput> {
    private String id;
    private JsonObject result;

    public GetRuleByIdAction(String id) {
        this.id = id;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.id)
            throw new OperationPlatformException("search rule by id must id is not null");
    }

    @Override
    protected void start() throws Exception {
        this.result = authService.getRuleById(this.id);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {

        SearchOutput output = new SearchOutput();
        if (Objects.equals(null, this.result)) {
            output.setSuccess("false");
        } else {
            output.setResult(this.result);
        }
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
