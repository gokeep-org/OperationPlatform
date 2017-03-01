package com.op.oauth.service;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/1.
 ****************************************/
public interface OauthService <T>{
    public T getTokenInfo();
    public T updateTokenInfo();
    public T deleteTokenInfo();
}
