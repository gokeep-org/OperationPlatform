package com.op.proxy.config;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public final class ErrorCode {
    //------------------------User--------------------------------------------
    public static final String USER_IS_NULL = "create user object is null";
    public static final String USER_IS_EXIST = "create user object is exist";
    public static final String NOT_PERMISSION = "not permission";

    //------------------------Token-------------------------------------------
    public static final String ACCESS_TOKEN_IS_NULL = "access token is null";
    public static final String USER_ID_IS_NULL = "user id is null";
    public static final String CHECK_ACCESS_TOKEN_FAILED = "check access_token is failed";
    public static final String GET_OLD_TOKEN_IS_NULL = "get old token is null";
    public static final String GET_TOKEN_INFO_ERROR = "get token is error";
    public static final String UPDATE_TOKEN_IS_ERROR = "update token is error";
    public static final String REFRESH_TOKEN_IS_FAILED = "refresh token is failed";

}
