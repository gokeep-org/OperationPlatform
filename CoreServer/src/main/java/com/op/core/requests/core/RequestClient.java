package com.op.core.requests.core;


import com.op.core.requests.exception.ErrorCode;
import com.op.core.requests.exception.RequestsException;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;


public abstract class RequestClient<T> {
    public static CloseableHttpClient httpClient;
    public static final Logger logger = LoggerFactory.getLogger(RequestClient.class);

    protected CloseableHttpClient openHttpClient() {
        httpClient = HttpClients.createDefault();
        return httpClient;
    }

    protected abstract T setUpHttpMethod();

    private void requestParamterFilter(String url) {
        if (null == url) {
            try {
                throw new RequestsException("request is bad, because url is null");
            } catch (RequestsException e) {
                throw new RequestsException("request is bad, because url is null", e);
            }
        }
    }

    protected abstract HttpResponse sendRequest(
            String url, Map<String, String> params, Map<String, String> postForms, Object body, Map<String, String> headers
    );

    protected com.op.core.requests.bean.HttpResponse execute(String url) {
        return execute(url, null, null, null, null);
    }

    protected com.op.core.requests.bean.HttpResponse execute(String url, Map<String, String> headers) {
        return execute(url, null, null, null, headers);
    }

    protected com.op.core.requests.bean.HttpResponse execute(String url, Map<String, String> params, Map<String, String> headers) {
        return execute(url, params, null, null, headers);
    }

    protected com.op.core.requests.bean.HttpResponse execute(String url, Map<String, String> params, Object body, Map<String, String> headers) {
        return execute(url, params, null, body, headers);
    }

    protected com.op.core.requests.bean.HttpResponse execute(String url, Map<String, String> params, Map<String, String> postForms, Object body, Map<String, String> headers) {
        openHttpClient();
        setUpHttpMethod();
        requestParamterFilter(url);
        HttpResponse httpResponse = sendRequest(url, params, postForms, body, headers);
        closeHttpClient();
        return new com.op.core.requests.bean.HttpResponse().setHttpResponse(httpResponse);
    }

    protected void closeHttpClient() {
        if (!Objects.equals(null, httpClient)) {
            try {
                if (Objects.equals(null, httpClient)) {
                    httpClient.close();
                }
            } catch (IOException e) {
                throw new RequestsException(ErrorCode.CLOSE_CLIENT_ERROR);
            }
        }
    }

    private String toLoggerMessage(String... strs) {
        String res = "";
        res += String.format(DefaultConfig.LOGGER_FORMATE,
                strs[0], strs[1], strs[2], strs[3], strs[4]);
        return res;
    }
}