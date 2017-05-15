package com.op.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.op.user.action.input.user.SearchInput;
import com.op.user.bean.ServiceName;
import com.op.user.bean.entity.user.Team;
import com.op.user.service.BaseService;
import com.op.user.service.TeamService;
import com.op.util.bean.Paging;
import com.op.util.bean.UriPath;
import com.op.util.common.RequestUtil;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.exception.output.ErrorInfo;
import com.op.util.gson.SerializeUtil;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
@Service(ServiceName.TEAM_SERVICE)
public class TeamServiceImpl extends BaseService implements TeamService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Boolean createTeam(Team team) {
        String result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/team", team, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean deleteTeamByTeamId(String teamId) {
        String result = requests.delete(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/team/" + teamId, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Boolean updateTeam(String teamId, Team team) {
        String result = requests.put(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/write/team/" + teamId, team, getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("success").getAsBoolean();
    }

    @Override
    public Team searchTeamByTeamId(String teamId) {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/team/" + teamId, getHeaders()).json();
        JsonObject json = ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).getAsJsonObject("result");
        return SerializeUtil.gson.fromJson(json, Team.class);
    }

    @Override
    public List searchTeamListByPaging(SearchInput input, Paging paging) {
        String result;
        //验证
        try {
            Map<String, String> params = new HashMap<>();
            params.put("page_now", String.valueOf(paging.getPageNow()));
            params.put("page_size", String.valueOf(paging.getPageSize()));
            params.put("field", paging.getField());
            params.put("order", paging.getOrder());
            result = requests.post(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/team/", params, input, getHeaders()).json();
        } catch (Throwable e) {
            //抛出结果获取异常
            result = SerializeUtil.transfromObjectToString(new ErrorInfo("500", "分页获取客户列表失败"));
        }
        if (null != result) {
            return (List) SerializeUtil.transfromStringToList(result);
        }
        return null;
    }

    @Override
    public long searchTeamTotal() {
        String result = requests.get(discoveryVip.choose(ServerName.CORE) + UriPath.CORE + "/read/team/total", getHeaders()).json();
        return ((JsonObject) SerializeUtil.transfromStringToObject(result, JsonObject.class)).get("total").getAsLong();
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
