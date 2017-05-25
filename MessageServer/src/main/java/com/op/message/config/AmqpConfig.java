//package com.op.message.config;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/5/22.
// ****************************************/
////@Configuration
//public class AmqpConfig {
//    private static final String addresses = "localhost:5672";
//    private static final String username = "xuning";
//    private static final String password  = "xuning!";
//    private static String virtualHost = "/";
//    private static boolean publisherConfirms = true;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setAddresses(addresses);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        connectionFactory.setVirtualHost(virtualHost);
//        /**
//         * 这里是必须设置消息回调机制的
//         * 由于内部内动画配置框架没有实现，这里不使用自动配资的方式
//         * 设置回调必须设置为true
//         */
//        connectionFactory.setPublisherConfirms(publisherConfirms);
//        return connectionFactory;
//    }
//
//    @Bean
//    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//    }
//}
