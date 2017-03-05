package com.op.oauth.action.token;

import com.op.oauth.action.item.ItemAction;
import com.op.oauth.bean.action.input.token.CheckTokenInput;
import com.op.oauth.bean.action.output.BaseOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-5
 ****************************************/
public class CheckTokenAction  extends ItemAction<BaseOutput> {
    private CheckTokenInput input;
    public CheckTokenAction(CheckTokenInput input) {
        this.input = input;
    }
    
    @Override
    protected void permissionValidate() throws Exception {
        
    }
    
    @Override
    protected void additionalValidate() throws Exception {
        
    }
    
    @Override
    protected void start() throws Exception {
        
    }
    
    @Override
    protected BaseOutput formatOutput() throws Exception {
        return null;
    }
    
    @Override
    protected void logSyncAction() throws Exception {
        
    }
}
