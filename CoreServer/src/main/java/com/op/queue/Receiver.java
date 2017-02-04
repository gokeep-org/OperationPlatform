package com.op.queue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/4.
 ****************************************/
@Component
@RabbitListener(queues = "customer")
@RabbitListener(queues = "user")
@RabbitListener(queues = "sys")
@RabbitListener(queues = "message")
public class Receiver{
	@RabbitHandler
	public void process(String jsonStr) {
		JSONObject jsonObject= JSON.parseObject(jsonStr);
		if (jsonObject.get("type").equals("customer")){
			System.out.println(jsonObject.toString());
		}else{
			System.out.println("不是客户");
		}
	}
}
