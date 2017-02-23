package com.op.bean.entity.template;

import com.op.bean.action.input.BaseInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/20.
 ****************************************/
public class MQ <T extends BaseInput>{
	public MQ(){}
	private String roteKey;
	private String type;
	private String http;
	private String oper;
	private String method;
	private T param;

	public String getRoteKey() {
		return roteKey;
	}

	public void setRoteKey(String roteKey) {
		this.roteKey = roteKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHttp() {
		return http;
	}

	public void setHttp(String http) {
		this.http = http;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}
}
