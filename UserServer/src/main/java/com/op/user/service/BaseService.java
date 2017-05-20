package com.op.user.service;


import com.op.user.util.ApplicationContextHolder;
import com.op.util.requests.Requests;

public abstract class BaseService {
    public static <T extends BaseService> T getService(Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(clazz);
    }

    public static <T extends BaseService> T getService(String serviceName, Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(serviceName, clazz);
    }


}