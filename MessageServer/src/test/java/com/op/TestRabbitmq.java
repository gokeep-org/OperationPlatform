package com.op;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.message.MessageBootstrap;
import com.op.message.library.queue.name.ServiceName;
import com.op.message.library.queue.Sender;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/20.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MessageBootstrap.class)
public class TestRabbitmq {
    @Autowired
    @Qualifier(value = ServiceName.RABBITMQ_LOG_SENDER)
    public Sender sender;

    @Test
    public void testSendMessage() {
        sender.send("hello");
    }


}