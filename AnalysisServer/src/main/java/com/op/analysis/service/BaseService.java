package com.op.analysis.service;


import com.op.analysis.util.ApplicationContextHolder;

public abstract class BaseService {
    public static <T extends BaseService> T getService(Class<T> clazz) {

        return ApplicationContextHolder.getContext().getBean(clazz);
    }

    public static <T extends BaseService> T getService(String serviceName, Class<T> clazz) {
        return ApplicationContextHolder.getContext().getBean(serviceName, clazz);
    }
}