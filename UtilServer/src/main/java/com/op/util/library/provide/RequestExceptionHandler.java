package com.op.util.library.provide;

import java.util.Map;

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

import com.op.util.exception.output.ErrorInfo;
import com.op.util.bean.HttpStatusCode;
import com.op.util.exception.OperationPlatformException;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/12.
 ****************************************/
@Provider
public class RequestExceptionHandler implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestExceptionHandler.class);
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
            String uuid = operationPlatformException.getUuid();
            String message = operationPlatformException.getMessage();
            message = (null == message) ? context.getMessage(code, null, exception.getMessage(),
                    request.getLocale()) : message;
            ErrorInfo errorOutput = new ErrorInfo(String.valueOf(code), message, uuid);
            syncErrorLogOutput(errorOutput);
            return Response.ok(errorOutput, MediaType.APPLICATION_JSON_TYPE).status(Integer.parseInt(code))
                    .build();
        }
        return Response.ok(SERVER_ERROR, MediaType.TEXT_PLAIN).status(Integer.parseInt(code))
                .build();
    }

    private void syncErrorLogOutput(ErrorInfo errorInfoOutput) {
        String userId = request.getHeader("user_id");
        String path = request.getRequestURI();
        String method = request.getMethod();
        Map<String, String[]> params = request.getParameterMap();
        String error = "request event found error info: [user_id: %s], [path: %s], [method: %s], [params: %s] [message: %s]. [code: %s], [uuid: %s]";
        error = String.format(error,
                userId,
                path,
                method,
                params,
                errorInfoOutput.getMesssage(),
                errorInfoOutput.getCode(),
                errorInfoOutput.getUuid());
        LOGGER.error(error);
    }
}