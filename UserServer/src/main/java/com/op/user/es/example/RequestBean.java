package com.op.user.es.example;

import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/13.
 ****************************************/
public class RequestBean {
    public String url;
    public String method;
    public Map<String, String> params;
    public List<Header> headers;
    public HttpEntity httpEntity;
    public RequestBean(String url, String method, Map<String, String> params, List<Header> headers, HttpEntity httpEntity) {
        this.url = url;
        this.method = method;
        this.params = params;
        this.headers = headers;
        this.httpEntity = httpEntity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public void setHttpEntity(HttpEntity httpEntity) {
        this.httpEntity = httpEntity;
    }
}
