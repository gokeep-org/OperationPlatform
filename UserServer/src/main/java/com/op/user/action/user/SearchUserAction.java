package com.op.user.action.user;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.entity.user.User;
import com.op.util.gson.SerializeUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public class SearchUserAction extends ItemAction<BaseOutput> {
    private String userId;
    private User user;
    private String result;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchUserAction.class);
    public SearchUserAction(String userId, User user) {
        this.userId = userId;
        this.user = user;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        if (Objects.equals(null, user))
            result = userService.searchUserByUserId(userId);
        else
            result = null;
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        Map<String, Object> map = (Map<String, Object>) SerializeUtil.transfromStringToObject(result, Map.class);
        SearchOutput output = new SearchOutput();
        output.setResult((Map<String, Object>) map.get("result"));
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search user is successful");
    }
}
