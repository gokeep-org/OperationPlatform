package com.op.customer.service.impl;

import com.op.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/22.
 ****************************************/
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void addUser(String name, int age) {
		jdbcTemplate.update("insert into USER (name, age) values(?,?)", name, age);
	}
}
