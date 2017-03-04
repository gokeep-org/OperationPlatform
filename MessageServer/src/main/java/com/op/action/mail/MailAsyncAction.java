package com.op.action.mail;

import com.google.gson.Gson;
import com.op.action.item.ItemAction;
import com.op.bean.action.input.email.MailSendInput;
import com.op.bean.action.output.email.MailSendOutput;
import com.op.bean.entity.email.Email;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public class MailAsyncAction extends ItemAction<MailSendOutput> {
    
    private Email email;
    
    public MailAsyncAction(MailSendInput input) {
        this.email = input;
    }
    
    @Override
    protected void permissionValidate() throws Exception {
        
    }
    
    @Override
    protected void additionalValidate() throws Exception {
        
    }
    
    @Override
    protected void start() {
        senderService.send("message", new Gson().toJson(email));
    }
    
    @Override
    protected MailSendOutput formatOutput() throws Exception {
        MailSendOutput opt = new MailSendOutput();
        return opt;
    }
    
    @Override
    protected void logSyncAction() throws Exception {
        
    }
}