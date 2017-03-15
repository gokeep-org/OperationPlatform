package com.op.es.config;

import java.util.ArrayList;
import java.util.List;

import requests.Requests;
import requests.core.RequestImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/15.
 ****************************************/
public class EsConfig {
    private static List<String> ServerList = new ArrayList<>();
    public static String masterNode = "http://localhost:9200";
    private static Requests requests = null;

    public static String getEsServer() {
        requests = new RequestImpl();
        return requests.get(masterNode + "/_nodes/").json();
    }


    public static List<String> getServerList() {
        return ServerList;
    }

    public static void setServerList(List<String> serverList) {
        ServerList = serverList;
    }

}
