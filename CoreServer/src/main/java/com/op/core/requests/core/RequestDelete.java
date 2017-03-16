package com.op.core.requests.core;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.GsonBuilder;
import com.op.core.requests.bean.HttpDelete;
import com.op.core.requests.exception.ErrorCode;
import com.op.core.requests.exception.RequestsException;
import com.op.core.requests.filter.RequestFilter;
import com.op.core.requests.util.RequestUtil;

public class RequestDelete extends RequestClient<HttpDelete> {
    private HttpResponse httpResponse;
    private HttpDelete httpDelete = new HttpDelete();
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestDelete.class);
    @Override
    protected HttpDelete setUpHttpMethod() {
        return httpDelete;
    }

    @Override
    protected HttpResponse sendRequest(String url, Map<String, String> params, Map<String, String> postForms, Object body, Map<String, String> headers) {
        if (!RequestFilter.checkHeaderisNull(headers)) {
            LOGGER.info("request headers : "+headers.toString());
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpDelete.setHeader(header.getKey(), header.getValue());
            }
        }
        this.httpDelete.setURI(RequestUtil.getURI(url));
        if (!RequestFilter.checkParamsIsNull(params)) {
            this.httpDelete.setURI(
                    RequestUtil.getURI(url + RequestUtil.buildParames(params))
            );
        }

        if (!RequestFilter.checkBodyIsNull(body)) {
            String bodyString = null;
            if(body instanceof String) {
                LOGGER.info("request body : "+body);
                bodyString = body.toString();
            } else {
                LOGGER.info("request body: is object or null");
                bodyString = new GsonBuilder().serializeNulls().create().toJson(body);
            }
            httpDelete.setEntity(RequestUtil.toStringEntity(bodyString));
        }

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setSocketTimeout(DefaultConfig.SOCKET_TIMOUT)
                .setConnectTimeout(DefaultConfig.CONNECTION_TIMOUT)
                .build();
        this.httpDelete.setConfig(requestConfig);
        try {
            httpResponse = httpClient.execute(this.httpDelete);
        } catch (IOException e) {
            throw new RequestsException(ErrorCode.RESULT_ERROR);
        }
        return httpResponse;
    }
}
