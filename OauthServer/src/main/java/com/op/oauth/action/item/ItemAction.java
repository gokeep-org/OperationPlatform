package com.op.oauth.action.item;


import com.op.oauth.action.BaseAction;
import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.service.AuthorizationService;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ClientService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.service.TokenService;
import com.op.oauth.service.UserService;
import com.op.oauth.service.impl.AuthorizationServiceImpl;
import com.op.oauth.service.impl.ClientServiceImpl;
import com.op.oauth.service.impl.TokenServiceImpl;
import com.op.oauth.service.impl.UserServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public static UserService userService = BaseService.getService(
            ServiceBeanNames.USER_SERVICE, UserServiceImpl.class
    );
    public static ClientService clientService = BaseService.getService(
            ServiceBeanNames.CLIENT_SERVICE, ClientServiceImpl.class
    );
    public static TokenService tokenService = BaseService.getService(
            ServiceBeanNames.TOKEN_SERVICE, TokenServiceImpl.class
    );
    public static AuthorizationService authorizationService = BaseService.getService(
            ServiceBeanNames.AUTHORIZATION_SERVICE, AuthorizationServiceImpl.class
    );
}