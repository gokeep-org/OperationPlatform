package com.op.oauth.service.impl;

import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Client;
import com.op.oauth.bean.entity.User;
import com.op.oauth.service.AuthorizationService;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.AUTHORIZATION_SERVICE)
public class AuthorizationServiceImpl extends BaseService implements AuthorizationService<Client, User> {
    @Override
    public Client authorization(User user) {
        return null;
    }
}
