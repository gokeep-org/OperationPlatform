package com.op.util.requests.core;

import com.google.gson.GsonBuilder;
import com.op.util.requests.bean.HttpDelete;
import com.op.util.requests.exception.ErrorCode;
import com.op.util.requests.exception.RequestsException;
import com.op.util.requests.filter.RequestFilter;
import com.op.util.requests.util.RequestUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

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
            if (body instanceof String) {
                bodyString = body.toString();
            } else {
                bodyString = new GsonBuilder().create().toJson(body);
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
