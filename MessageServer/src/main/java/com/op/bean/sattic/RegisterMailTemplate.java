package com.op.bean.sattic;

import com.op.bean.email.Email;
import com.op.util.PropertiesUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/16.
 ****************************************/
public class RegisterMailTemplate extends Email{
	public RegisterMailTemplate(){
		super();
		PropertiesUtil.setConfigFileName("template.properties");
		this.setAccepter(PropertiesUtil.getValue("accept"));
		this.setAccepter(PropertiesUtil.getValue("accept"));
		this.setAccepter(PropertiesUtil.getValue("accept"));
	}

}
