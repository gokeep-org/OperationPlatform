package com.op.oauth.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Client;
import com.op.oauth.bean.entity.User;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ClientService;
import com.op.oauth.service.ServiceBeanNames;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.CLIENT_SERVICE)
public class ClientServiceImpl extends BaseService implements ClientService<Client, Boolean, User>{
    @Override
    public Boolean createClient(Client client) {
        return null;
    }

    @Override
    public Boolean deleteClient(Client client) {
        return null;
    }

    @Override
    public Boolean updateClient(Client client) {
        return null;
    }

    @Override
    public Client getClientByClientId(String clientId) {
        return null;
    }

    @Override
    public List<Client> getClientByUserId(String userId) {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }

    @Override
    public Client freezeClientByClientId(String clientId) {
        return null;
    }
}
