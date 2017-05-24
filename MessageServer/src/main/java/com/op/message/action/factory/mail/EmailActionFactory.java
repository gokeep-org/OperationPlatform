package com.op.message.action.factory.mail;

import com.op.message.action.factory.BaseActionFactory;
import com.op.message.action.mail.MailAsyncAction;
import com.op.message.action.mail.MailSyncAction;
import com.op.message.bean.action.input.email.MailSendInput;
import com.op.message.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public class EmailActionFactory extends BaseActionFactory {

    public static MailAsyncAction getMailAsyncSendAction(MailSendInput input) throws Exception {
        User user = getUser();
        return new MailAsyncAction(input);
    }

    public static MailSyncAction getMailSyncSendAction(MailSendInput input) throws Exception {
        return new MailSyncAction(input);
    }
}