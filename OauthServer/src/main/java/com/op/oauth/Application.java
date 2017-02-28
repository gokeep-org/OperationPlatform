package com.op.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/22.
 ****************************************/
@EnableAuthorizationServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Arrays.asList(authenticationProvider));
	}
}