package com.op.util.requests.core;

import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/6.
 ****************************************/
public class HttpConnectionManager {
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;
    private static LayeredConnectionSocketFactory layeredConnectionSocketFactory = null;
    private static int maxTotalConnection = 20000;
    private static int defaultMaxPerRoute = 200;

    /**
     * Http 连接池处理类
     */
    static {
        try {
            layeredConnectionSocketFactory = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            throw new OperationPlatformException("new SSLConnection is error");
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", layeredConnectionSocketFactory)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        poolingHttpClientConnectionManager.setMaxTotal(maxTotalConnection);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
    }

    /**
     * 获取连接池中的连接对象
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .build();
        return httpClient;
    }

    public static int getMaxTotalConnection() {
        return maxTotalConnection;
    }

    public static void setMaxTotalConnection(int maxTotalConnection) {
        HttpConnectionManager.maxTotalConnection = maxTotalConnection;
    }

    public static int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public static void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        HttpConnectionManager.defaultMaxPerRoute = defaultMaxPerRoute;
    }

}
