package com.op.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.op.user.action.output.ErrorInfoOutput;
import com.op.user.bean.entity.user.User;
import com.op.user.service.UserService;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class UserServiceImpl implements UserService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;

    @Override
    public String createOneUser(User user) {
        String result;
        //验证
        try {
            result = requests.post(discoveryVip.choose(ServerName.CORE) + "/user", user, getHeaders()).json();
        }catch (Throwable e){
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "添加用户失败"));
        }
        return result;
    }

    @Override
    public String createUsers(List<User> users) {
        String result;
        //验证
        try {
            result = requests.post(discoveryVip.choose(ServerName.CORE) + "/user/batch", users, getHeaders()).json();
        }catch (Throwable e){
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "批量添加用户失败"));
        }
        return result;
    }

    @Override
    public String deleteUserByUserId(String userId) {
        String result;
        //验证
        try {
            result = requests.delete(discoveryVip.choose(ServerName.CORE) + "/user/"+userId, null, getHeaders()).json();
        }catch (Throwable e){
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "删除用户失败"));
        }
        return result;
    }

    @Override
    public String deleteUser(User user) {
        String result;
        //验证
        try {
            result = requests.delete(discoveryVip.choose(ServerName.CORE) + "/user/", null, getHeaders()).json();
        }catch (Throwable e){
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "添加失败"));
        }
        return result;
    }

    @Override
    public String updateUserByUserId(User user) {
        String result;
        //验证
        try {
            result = requests.put(discoveryVip.choose(ServerName.CORE) + "/user/"+user.getId(), user, getHeaders()).json();
        }catch (Throwable e){
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "更新用户失败"));
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public User searchUserByUserId(String userId) {
        return null;
    }

    @Override
    public List<User> searchUser(User user) {
        return null;
    }

    @Override
    public Long size() {
        return null;
    }

    @Override
    public Long size(User user) {
        return null;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public static final Map getHeaders() {
        final Map headers = new HashMap();
        headers.put("Content-Type", MediaType.APPLICATION_JSON);
        headers.put("Accept", MediaType.APPLICATION_JSON);
        return headers;
    }
}
