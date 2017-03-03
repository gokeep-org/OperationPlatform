package com.op.oauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.Client;
import com.op.oauth.bean.entity.User;
import com.op.oauth.dao.ClientMapper;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ClientService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.CLIENT_SERVICE)
public class ClientServiceImpl extends BaseService implements ClientService<Client, Boolean, User> {
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Boolean createClient(Client client) {
        return OpUtils.checkMapperCudIsSuccess(
                clientMapper.insert(client)
        );
    }

    @Override
    public Boolean deleteClient(String clientId) {
        return OpUtils.checkMapperCudIsSuccess(
                clientMapper.deleteClientByClientId(clientId)
        );
    }

    @Override
    public Boolean updateClient(Client client) {
        return OpUtils.checkMapperCudIsSuccess(
                clientMapper.updateByClientId(client)
        );
    }

    @Override
    public Client getClientByClientId(String clientId) {
        return clientMapper.selectByClientId(clientId);
    }

    @Override
    public List<Client> getClientByUserId(String userId) {
        return clientMapper.selectByUserId(userId);
    }

    @Override
    public List<Client> getAllClient() {
        return clientMapper.selectAll();
    }

    @Override
    public Boolean freezeClientByClientId(String clientId) {
        return OpUtils.checkMapperCudIsSuccess(
                clientMapper.freezeClientByClientId(clientId)
        );
    }
}
