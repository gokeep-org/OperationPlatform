package com.op.util.rest;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/23.
 ****************************************/
public class RestClient {
    /**
     * 用户强化RestTemplate。
     * 由于自己实现的Requests框架发送消息无法实现负载均衡
     * 这里可以考虑使用ResTemplate实现
     */

    public static String version() {
        return "v1.0";
    }


}
