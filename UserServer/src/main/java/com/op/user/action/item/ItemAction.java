package com.op.user.action.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.op.user.action.BaseAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.bean.ServiceName;
import com.op.user.service.BaseService;
import com.op.user.service.CommonService;
import com.op.user.service.TeamService;
import com.op.user.service.UserService;
import com.op.user.service.impl.CommonServiceImpl;
import com.op.user.service.impl.TeamServiceImpl;
import com.op.user.service.impl.UserServiceImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public abstract class ItemAction<T extends BaseOutput> extends BaseAction<T> {
    public UserService userService = BaseService.getService(ServiceName.USER_SERVICE, UserServiceImpl.class);
    public TeamService teamService = BaseService.getService(ServiceName.TEAM_SERVICE, TeamServiceImpl.class);
    public CommonService commonService = BaseService.getService(ServiceName.COMMON_SERVICE, CommonServiceImpl.class);

    private HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    public String getUserId() {
        return request.getHeader("user_id");
    }
}
