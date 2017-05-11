package com.op.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.user.action.input.user.SearchInput;
import com.op.user.action.output.ErrorInfoOutput;
import com.op.user.bean.ServiceName;
import com.op.user.bean.entity.user.User;
import com.op.user.exception.OperationPlatformException;
import com.op.user.service.BaseService;
import com.op.user.service.UserService;
import com.op.util.bean.CommonQueryBody;
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
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "根据ID删除用户失败"));
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
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "删除用户失败"));
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
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "根据用户Id查询用户失败"));
        }
        return result;
    }

    @Override
    public List searchUserByPaging(SearchInput searchInput, Paging paging) {
        String result;
        //验证
        try {
            Map<String, String> params = new HashMap<>();
            params.put("page_now", String.valueOf(paging.getPageNow()));
            params.put("page_size", String.valueOf(paging.getPageSize()));
            params.put("field", paging.getField());
            params.put("order", paging.getOrder());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/", params, searchInput, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "分页获取用户列表失败"));
        }
        if (null != result) {
            return (List) SerializeUtil.transfromStringToList(result);
        }
        return null;
    }

    @Override
    public List<User> searchUser(CommonQueryBody body) {
        String result;
        //验证
        try {
            String resTotal = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/total").json();
            long total = ((JsonObject) SerializeUtil.transfromStringToObject(resTotal, JsonObject.class)).get("total").getAsLong();
            if (total == 0) {
                return null;
            }
            Map<String, String> params = new HashMap<>();
            params.put("page_now", "1");
            params.put("page_size", String.valueOf(total));
            params.put("field", "create_time");
            params.put("order", "descend");
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/", params, body, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "根据body查询用户失败"));
        }
        if (null != result) {
            return (List) SerializeUtil.transfromStringToList(result);
        }
        return null;
    }

    @Override
    public Long size() {
        String result = null;
        try {
            result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/total", null, getHeaders()).json();
        } catch (Throwable e) {
            throw new OperationPlatformException("获取用户数目失败");
        }
        JsonObject res = (JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class);
        return res.get("total").getAsLong();
    }

    // TODO: 对象条件过滤未完成，这里临时为所有文档数目，改期
    @Override
    public Long size(SearchInput searchInput) {
        String result = null;
        //验证
        try {
            result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/user/total", null, getHeaders()).json();
        } catch (Throwable e) {
            //跑出异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "获取用户数目失败"));
        }
        JsonObject res = (JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class);
        return res.get("total").getAsLong();
    }

    @Override
    public Boolean syncUserToMysql(User user) {
        String result;
        //验证
        try {
            result = requests.post(discoveryVip.choose(ServerName.OAUTH) + UriPath.OAUTH + "/user", user, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfoOutput("500", "根据body查询用户失败"));
        }
        if (null != result) {
            return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
        }
        return false;
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
