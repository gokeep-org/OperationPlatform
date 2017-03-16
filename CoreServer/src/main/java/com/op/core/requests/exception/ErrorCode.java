package com.op.core.requests.exception;

public class ErrorCode {
    private ErrorCode() {
    }

    public static final String RESULT_ERROR = "request get response is error";
    public static final String RESULT_TO_STR_IS_ERROR = "request translation string is error";
    public static final String CLOSE_CLIENT_ERROR = "close client is error";
    public static final String NOT_FOUND_URL = "not found request url";
    public static final String POST_FORM_TRANSLATION_ERROR = "post form translation is error";

}
