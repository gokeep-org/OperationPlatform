package com.op.user.action.factory;

import com.op.user.action.BaseActionFactory;
import com.op.user.action.input.user.SearchInput;
import com.op.user.action.team.CreateTeamAction;
import com.op.user.action.team.DeleteTeamAction;
import com.op.user.action.team.PagingSearchTeamAction;
import com.op.user.action.team.SearchTeamByTeamIdAction;
import com.op.user.action.team.SearchTeamTotalAction;
import com.op.user.action.team.UpdateTeamAction;
import com.op.user.bean.entity.user.Team;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
public class TeamActionFactory extends BaseActionFactory {
    public static CreateTeamAction getCreateTeamAction(Team team) {
        return new CreateTeamAction(team);
    }

    public static DeleteTeamAction getDeleteTeamAction(String teamId) {
        return new DeleteTeamAction(teamId);
    }

    public static UpdateTeamAction getUpdateTeamAction(String teamId, Team team) {
        return new UpdateTeamAction(teamId, team);
    }

    public static SearchTeamByTeamIdAction getSearchTeamByTeamIdAction(String teamId) {
        return new SearchTeamByTeamIdAction(teamId);
    }

    public static PagingSearchTeamAction getPagingSearchTeamAction(SearchInput input, Paging paging) {
        return new PagingSearchTeamAction(input, paging);
    }

    public static SearchTeamTotalAction getSearchTeamTotalAction(){
        return new SearchTeamTotalAction();
    }
}
