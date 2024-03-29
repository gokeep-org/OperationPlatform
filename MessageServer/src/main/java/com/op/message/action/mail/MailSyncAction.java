package com.op.message.action.mail;

import com.op.message.bean.action.output.email.MailSendOutput;
import com.op.message.bean.entity.email.Email;
import com.op.message.action.item.ItemAction;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/28.
 ****************************************/
public class MailSyncAction extends ItemAction<MailSendOutput> {

    private Email email;

    public MailSyncAction(Email email) {
        this.email = email;
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
    protected MailSendOutput formatOutput() throws Exception {
        Boolean res = mailSendService.sendCommonEmail(this.email);
        MailSendOutput output = new MailSendOutput();
        output.setSuccess(res.toString());
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {

    }
}
