package com.op.util.requests.bean;

import com.google.gson.Gson;
import com.op.util.requests.bean.data.DataType;
import com.op.util.requests.exception.ErrorCode;
import com.op.util.requests.exception.RequestsException;

import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpResponse implements DataType {
    private org.apache.http.HttpResponse httpResponse;

    public HttpResponse() {
    }

    public org.apache.http.HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public HttpResponse setHttpResponse(org.apache.http.HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
        return this;
    }

    @Override
    public String json() {
        String str = getHttpResponseStr();
        return str;
    }

    @Override
    public String text() {
        return getHttpResponseStr();
    }

    //暂不实现
    @Override
    public InputStream inputStream() {
        return null;
    }

    @Override
    public int statusCode() {
        return httpResponse.getStatusLine().getStatusCode();
    }

    @Override
    public Object toObject(Class classes) {
        return new Gson().fromJson(json(), classes);
    }

    private String getHttpResponseStr() {
        String strRes = falg;
        try {
            strRes = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            if (strRes.equals(falg)) {
                throw new RequestsException(ErrorCode.RESULT_TO_STR_IS_ERROR);
            }
            return strRes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strRes;
    }
}
