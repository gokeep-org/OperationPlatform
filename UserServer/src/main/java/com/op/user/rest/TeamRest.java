package com.op.user.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.op.user.action.factory.TeamActionFactory;
import com.op.user.action.input.user.SearchInput;
import com.op.user.action.output.ResultMessage;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.Team;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/15.
 ****************************************/
@Path("/team")
@Produces({MediaType.APPLICATION_JSON})
public class TeamRest {

    /**
     * 添加团队信息
     * @param team
     * @return
     */
    @POST
    public ResultMessage createTeam(Team team) throws Exception {
        return TeamActionFactory.getCreateTeamAction(team).execute();
    }

    /**
     * 删除团队信息通过团队Id
     * @param teamId
     * @return
     * @throws Exception
     */
    @DELETE
    @Path("/{id}")
    public ResultMessage deleteTeamByTeamId(@PathParam("id") String teamId) throws Exception {
        return TeamActionFactory.getDeleteTeamAction(teamId).execute();
    }

    /**
     * 更新团队信息根据团队ID
     * @param team
     * @param teamId
     * @return
     * @throws Exception
     */
    @PUT
    @Path("/{id}")
    public ResultMessage updateTeamByTeamId(Team team,
                                            @PathParam("id") String teamId) throws Exception {
        return TeamActionFactory.getUpdateTeamAction(teamId, team).execute();
    }

    /**
     * 根据ID查询团队信息
     * @param teamId
     * @return
     * @throws Exception
     */
    @GET
    @Path("/{id}")
    public SearchOutput searchTeamByTeamId(@PathParam("id") String teamId) throws Exception {
        return TeamActionFactory.getSearchTeamByTeamIdAction(teamId).execute();
    }

    /**
     * 分页查询团队信息
     * @param searchInput
     * @param pageNow
     * @param pageSize
     * @param field
     * @param order
     * @return
     * @throws Exception
     */
    @POST
    @Path("/search")
    public SearchOutput searchTeamByPaging(SearchInput searchInput,
                                           @QueryParam("page_now") @DefaultValue("1") int pageNow,
                                           @QueryParam("page_size") @DefaultValue("10") int pageSize,
                                           @QueryParam("field") @DefaultValue("create_time") String field,
                                           @QueryParam("order") @DefaultValue("descend") String order) throws Exception {
        Paging paging = new Paging(pageNow, pageSize, field, order);
        return TeamActionFactory.getPagingSearchTeamAction(searchInput, paging).execute();
    }

    /**
     * 查询团队数目
     * @return
     * @throws Exception
     */
    @GET
    @Path("/total")
    public SearchOutput seachTeamTotal() throws Exception {
        return TeamActionFactory.getSearchTeamTotalAction().execute();
    }
}
