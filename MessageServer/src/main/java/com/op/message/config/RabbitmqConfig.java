//package com.op.message.config;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//
//import com.op.message.util.PropertiesUtil;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/2/20.
// ****************************************/
//public class RabbitmqConfig {
//	private static final PropertiesUtil propertiesUtil = new PropertiesUtil("rabbitmq.properties");
//	private static final String rabbitmqHost = PropertiesUtil.getValue("spring.rabbitmq.host");
//	private static final String rabbitmqUsername = PropertiesUtil.getValue("spring.rabbitmq.username");
//	private static final String rabbitmqPassword = PropertiesUtil.getValue("spring.rabbitmq.password");
//	private static final String rabbitmqPublisherConfirms = PropertiesUtil.getValue("spring.rabbitmq.publisher-confirms");
//	public static final int rabbitmqPort = Integer.parseInt(PropertiesUtil.getValue("spring.rabbitmq.port"));
//
//
////	@Bean
//	public ConnectionFactory connectionFactory() {
//		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//		connectionFactory.setAddresses(rabbitmqHost);
//		connectionFactory.setUsername(rabbitmqUsername);
//		connectionFactory.setPassword(rabbitmqPassword);
//		connectionFactory.setPort(rabbitmqPort);
//		return connectionFactory;
//	}
//
////	@Bean
////	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//	public RabbitTemplate rabbitTemplate() {
//		RabbitTemplate template = new RabbitTemplate(connectionFactory());
//		return template;
//	}
//}
