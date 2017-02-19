package com.op.config;

import com.op.bean.action.output.ErrorInfoOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/17.
 ****************************************/
@Provider
public class OpResponseFilter implements ContainerResponseFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(OpResponseFilter.class);
	@Context
	private HttpServletRequest request;
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		if(!(responseContext.getStatus() == 200)){
			ErrorInfoOutput info = new ErrorInfoOutput();
			info.setCode(String.valueOf(responseContext.getStatus()));
			info.setMesssage(responseContext.getStatusInfo().toString());
			info.setSuccess("false");
			responseContext.setEntity(info);
		}
//		responseContext.setEntity("status isz: "+responseContext.getStatus());
		LOGGER.info("response sttaus is "+responseContext.getStatus());
	}
}