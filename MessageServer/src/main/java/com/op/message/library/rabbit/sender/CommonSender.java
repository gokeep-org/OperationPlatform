package com.op.message.library.rabbit.sender;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/1.
 ****************************************/
public interface CommonSender {
    public void send(String queueName, String message);
}
