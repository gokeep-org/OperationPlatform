package com.op.message.config;

import com.op.message.util.PropertiesUtil;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/20.
 ****************************************/
@Configuration
public class RabbitmqConfig {
	private static final PropertiesUtil propertiesUtil = new PropertiesUtil("rabbitmq.properties");
	private static final String rabbitmqHost = propertiesUtil.getValue("spring.rabbitmq.host");
	private static final String rabbitmqUsername = propertiesUtil.getValue("spring.rabbitmq.username");
	private static final String rabbitmqPassword = propertiesUtil.getValue("spring.rabbitmq.password");
	private static final String rabbitmqPublisherConfirms = propertiesUtil.getValue("spring.rabbitmq.publisher-confirms");
	public static final int rabbitmqPort = Integer.parseInt(propertiesUtil.getValue("spring.rabbitmq.port"));


	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(rabbitmqHost);
		connectionFactory.setUsername(rabbitmqUsername);
		connectionFactory.setPassword(rabbitmqPassword);
		connectionFactory.setPort(rabbitmqPort);
//		connectionFactory.setPublisherConfirms(Boolean.parseBoolean(rabbitmqPublisherConfirms));
		return connectionFactory;
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}
}
