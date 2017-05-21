package com.op.proxy.util.auth;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/21.
 ****************************************/
public interface AuthService {
    //获取上下文
    public String getUserId();

    //验证Token
    public Boolean checkToken(String accessToken, String userId);
}
