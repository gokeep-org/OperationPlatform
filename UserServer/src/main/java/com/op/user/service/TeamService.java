package com.op.user.service;

import java.util.List;

import com.op.user.action.input.user.SearchInput;
import com.op.user.bean.entity.user.Team;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public interface TeamService {
    public Boolean createTeam(Team team);

    public Boolean deleteTeamByTeamId(String teamId);

    public Boolean updateTeam(String teamId, Team team);

    public Team searchTeamByTeamId(String teamId);

    public List searchTeamListByPaging(SearchInput input, Paging paging);

    public long searchTeamTotal();
}
