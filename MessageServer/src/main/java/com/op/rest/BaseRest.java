package com.op.rest;

import org.springframework.beans.factory.annotation.Autowired;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/31.
 ****************************************/
public class BaseRest<T> {
	@Autowired
	private T t;
}
