package com.op.oauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.oauth.bean.entity.User;
import com.op.oauth.dao.UserMapper;
import com.op.oauth.service.BaseService;
import com.op.oauth.service.ServiceBeanNames;
import com.op.oauth.service.UserService;
import com.op.oauth.util.OpUtils;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
@Service(ServiceBeanNames.USER_SERVICE)
public class UserServiceImpl extends BaseService implements UserService<User, Boolean> {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean createUser(User user) {
        int res = userMapper.insert(user);
        return OpUtils.checkMapperCudIsSuccess(res);
    }

    @Override
    public Boolean updateUser(User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(User user) {
        return null;
    }

    @Override
    public Boolean freezeUser(String userId) {
        return null;
    }

    @Override
    public User getUserById(String userId) {
       User user =  userMapper.selectByPrimaryKey(userId);
       return user;
    }

    @Override
    public User getUserByToken(String accessToken) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public Boolean checkoutUserNameIsExist(User user) {
        if (userMapper.checkoutUserNameIsExist(user).size() == 0) {
            return false;
        }
        return true;
    }
}
