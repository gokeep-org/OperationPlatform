package com.op.proxy.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/4.
 ****************************************/
@Configuration
public class RabbitmqConfig {
	@Bean
	public Queue customerQueue() {
		return new Queue("oauth");
	}

	@Bean
	public Queue userQueue() {
		return new Queue("user");
	}

	@Bean
	public Queue sysQueue() {
		return new Queue("sys");
	}

	@Bean
	public Queue messageQueue() {
		return new Queue("message");
	}
}

