package com.op.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/22.
 ****************************************/
@SpringBootApplication
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}