package com.op.oauth.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-4
 ****************************************/
//@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class, OperationPlatformException.class})
    @ResponseBody
    public OperationPlatformException exceptionHandler(RuntimeException e, HttpServletResponse response) {
        OperationPlatformException opException = new OperationPlatformException();
        opException.setCode("300");
        return opException;
    }
}