package com.op.oauth.config;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import com.op.oauth.bean.action.output.ErrorInfoOutput;
import com.op.oauth.bean.action.output.HttpStatusCode;
import com.op.oauth.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/12.
 ****************************************/
@Provider
public class JerseyExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyExceptionHandler.class);
    private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

    @Context
    private ServletContext servletContext;
    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(Exception exception) {
        String code = HttpStatusCode.SERVER_ERROR;
        String SERVER_ERROR = "server error";
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(CONTEXT_ATTRIBUTE);
        if (exception instanceof OperationPlatformException) {
            OperationPlatformException operationPlatformException = (OperationPlatformException) exception;
            code = operationPlatformException.getCode();
            code = (null == code ? HttpStatusCode.SERVER_ERROR : operationPlatformException.getCode());
            String message = context.getMessage(code, null, exception.getMessage().split(":")[1],
                    request.getLocale());
            ErrorInfoOutput errorOutput = new ErrorInfoOutput(String.valueOf(code), message);
            return Response.ok(errorOutput, MediaType.APPLICATION_JSON_TYPE).status(Integer.parseInt(code))
                    .build();
        }
        return Response.ok(SERVER_ERROR, MediaType.TEXT_PLAIN).status(Integer.parseInt(code))
                .build();
    }
}