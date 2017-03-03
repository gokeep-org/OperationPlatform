package com.op.oauth.exception;

import com.op.oauth.bean.action.output.HttpStatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-4
 ****************************************/
@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionMapperSupport.class);
    private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
    @Context
    private HttpServletRequest request;
    
    @Context
    private ServletContext servletContext;
    @Override
    public Response toResponse(Exception exception) {
        String code = HttpStatusCode.SERVER_ERROR;
        String SERVER_ERROR = "server error";
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(CONTEXT_ATTRIBUTE);
        if (exception instanceof OperationPlatformException) {
            OperationPlatformException operationPlatformException = (OperationPlatformException) exception;
            code = operationPlatformException.getCode();
            code = (null == code?HttpStatusCode.SERVER_ERROR:operationPlatformException.getCode());
            String message = context.getMessage(code,null, exception.getMessage(),
                    request.getLocale());
            return Response.ok(message, MediaType.TEXT_PLAIN).status(Integer.parseInt(code))
                    .build();
        }
        return Response.ok(SERVER_ERROR, MediaType.TEXT_PLAIN).status(Integer.parseInt(code))
                .build();
    }
}
