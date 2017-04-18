package com.op.es.util;

import java.util.Arrays;
import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/15.
 ****************************************/
public class Server {

    public static final String PROXY_SERVER = "PROXY";
    public static final String EUREKA_SERVER = "EUREKA";
    public static final String ES_SERVER = "ES";
    public static final String CUSTOMER_SERVER = "CUSTOMER";
    public static final String USER_SERVER = "USER";
    public static final String OAUTH_SERVER = "OAUTH";
    public static final String MESSAGE_SERVER = "MESSAGE";
    private static List<String> serverList = Arrays.asList(
            PROXY_SERVER,
            EUREKA_SERVER,
            ES_SERVER,
            CUSTOMER_SERVER,
            USER_SERVER,
            OAUTH_SERVER,
            MESSAGE_SERVER
    );

    private Server() {
    }

    public static List<String> getServerList() {
        return serverList;
    }

    public final static List<String> removeServer(String... serverName) {
        serverList.remove(serverName);
        return serverList;
    }

    public final static List<String> addServer(String... serverName) {
        for (String name : serverName) {
            serverList.add(name);
        }
        return serverList;
    }
}
