package com.op.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.user.action.output.ErrorInfoOutput;
import com.op.user.bean.ServiceName;
import com.op.user.bean.entity.user.User;
import com.op.user.service.BaseService;
import com.op.user.service.UserService;
import com.op.util.bean.Paging;
import com.op.util.bean.UriPath;
import com.op.util.common.RequestUtil;
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
@Service(ServiceName.USER_SERVICE)
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public String createOneUser(User user) {
        String result;
        try {
            user.setId(UUID.randomUUID().toString());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/user", user, getHeaders()).json();
        } catch (Throwable e) {
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "添加用户失败"));
        }
        return result;
    }

    @Override
    public String createUsers(List<User> users) {
        String result;
        //验证
        try {
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/user/batch", users, getHeaders()).json();
        } catch (Throwable e) {
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "批量添加用户失败"));
        }
        return result;
    }

    @Override
    public String deleteUserByUserId(String userId) {
        String result;
        //验证
        try {
            result = requests.delete(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/user/" + userId, null, getHeaders()).json();
        } catch (Throwable e) {
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "删除用户失败"));
        }
        return result;
    }

    @Override
    public String deleteUser(User user) {
        String result;
        //验证
        try {
            result = requests.delete(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/user/", null, getHeaders()).json();
        } catch (Throwable e) {
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "添加失败"));
        }
        return result;
    }

    @Override
    public String updateUserByUserId(User user) {
        String result;
        //验证
        try {
            result = requests.put(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/user/" + user.getId(), user, getHeaders()).json();
        } catch (Throwable e) {
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "更新用户失败"));
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public String searchUserByUserId(String userId) {
        String result;
        //验证
        try {
            result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/" + userId, null, getHeaders()).json();
        } catch (Throwable e) {
            //跑出异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "更新用户失败"));
        }
        return result;
    }

    @Override
    public List searchUserByPaging(User user, Paging paging) {
        String result;
        //验证
        try {
            Map<String, String> params = new HashMap<>();
            params.put("page_now", String.valueOf(paging.getPageNow()));
            params.put("page_size", String.valueOf(paging.getPageSize()));
            params.put("field", paging.getField());
            params.put("order", paging.getOrder());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/", params, user, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "更新用户失败"));
        }
        if (null != result) {
            return (List) SerializeUtil.transfromStringToList(result);
        }
        return null;
    }

    @Override
    public List<User> searchUser(User user) {
        return null;
    }

    @Override
    public Long size() {
        String result;
        //验证
        try {
            result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/size", null, getHeaders()).json();
        } catch (Throwable e) {
            //跑出异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "更新用户失败"));
        }
        JsonObject res = (JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class);
        return res.get("total").getAsLong();
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

    public DiscoveryVip getDiscoveryVip() {
        return discoveryVip;
    }

    public void setDiscoveryVip(DiscoveryVip discoveryVip) {
        this.discoveryVip = discoveryVip;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public Map<String, String> getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }
}
