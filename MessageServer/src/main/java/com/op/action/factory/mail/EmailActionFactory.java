package com.op.action.factory.mail;

import com.op.action.factory.BaseActionFactory;
import com.op.action.mail.MailAction;
import com.op.bean.action.input.email.MailSendInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public class EmailActionFactory extends BaseActionFactory {
    public static MailAction getMailSendAction(MailSendInput input) throws Exception {
        return new MailAction(input);
    }
}