package com.op.util.requests;


import com.op.util.requests.bean.HttpResponse;

import java.util.Map;

public interface Requests {

    public HttpResponse get(
            String url
    );

    public HttpResponse get(
            String url, Map<String, String> params
    );

    public HttpResponse get(
            String url, Map<String, String> params, Map<String, String> headers
    );

    public HttpResponse post(
            String url
    );

    public HttpResponse post(
            String url, Map<String, String> headers
    );

    public HttpResponse post(
            String url, Map<String, String> params, Map<String, String> headers
    );

    public HttpResponse post(
            String url, Map<String, String> params, Map<String, String> postForms, Map<String, String> headers
    );

    public HttpResponse post(
            String url, Object body, Map<String, String> headers
    );

    public HttpResponse post(
            String url, Map<String, String> params, Object body, Map<String, String> headers
    );

    public HttpResponse put(
            String url
    );

    public HttpResponse put(
            String url, Map<String, String> headers
    );

    public HttpResponse put(
            String url, Map<String, String> params, Map<String, String> headers
    );

    public HttpResponse put(
            String url, Map<String, String> params, Object body, Map<String, String> headers
    );

    public HttpResponse put(
            String url, Object body, Map<String, String> headers
    );

    public HttpResponse delete(
            String url
    );

    public HttpResponse delete(
            String url, Map<String, String> headers
    );

    public HttpResponse delete(
            String url, Map<String, String> params, Map<String, String> headers
    );

    public HttpResponse delete(
            String url, Map<String, String> params, Object body, Map<String, String> headers
    );

    public HttpResponse delete(
            String url, Object body, Map<String, String> headers
    );

    public HttpResponse request(
            String url, String method
    );

    public HttpResponse request(
            String url, String method, Map<String, String> headers
    );

    public HttpResponse request(
            String url, String method, Map<String, String> params, Map<String, String> headers
    );

    public HttpResponse request(
            String url, String method, Map<String, String> params, Object body, Map<String, String> headers
    );

    public HttpResponse request(
            String url, String method, Map<String, String> params, Map<String, Object> postForms, Object body, Map<String, String> headers
    );
}