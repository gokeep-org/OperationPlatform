package com.op.user.action.user;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.input.user.SearchInput;
import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.User;
import com.op.user.exception.OperationPlatformException;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/5.
 ****************************************/
public class SearchUserListAction extends ItemAction<BaseOutput> {
    private SearchInput searchBody;
    private Paging paging;
    private List list;
    private long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchUserListAction.class);
    public SearchUserListAction(SearchInput searchInput, Paging paging) {
        this.searchBody = searchInput;
        this.paging = paging;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
//        if (Objects.equals(null, this.)) {
//            throw new OperationPlatformException("search user is must not null");
//        }
    }

    @Override
    protected void start() throws Exception {
        this.list = userService.searchUserByPaging(this.searchBody, this.paging);
        this.total = userService.size(this.searchBody);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setList(this.list);
        output.setTotal(this.total);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search user list is successful");
    }
}