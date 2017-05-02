package com.op.util.common;

import java.util.HashMap;
import java.util.Map;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/2.
 ****************************************/
public class RequestUtil {
    private RequestUtil() {
    }

    public final static Map getRequestHeaders() {
        Map headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("cache-control", "no-cache");
        return headers;
    }

    public static Map buildAuth(String userId, String accessToken) {
        Map header = getRequestHeaders();
        header.put("user_id", userId);
        header.put("access_token", accessToken);
        return header;
    }

    public static Map setUserIdToRequest(String userId) {
        Map header = getRequestHeaders();
        header.put("user_id", userId);
        return header;
    }
}
