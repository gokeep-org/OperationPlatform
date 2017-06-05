package com.op.user.action.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.op.user.action.item.ItemAction;
import com.op.user.action.output.BaseOutput;
import com.op.user.action.output.SearchOutput;
import com.op.user.bean.LogMessage;
import com.op.user.bean.entity.user.User;
import com.op.util.bean.log.MessageLog;
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

        this.result = userService.searchUserByUserId(this.userId);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        Map<String, Object> map = (Map<String, Object>) SerializeUtil.transfromStringToObject(this.result, Map.class);
        SearchOutput output = new SearchOutput();
        output.setResult(map.get("result"));
        return output;
    }

    @Override
    @Async
    protected void logSyncAction() throws Exception {
        LOGGER.info(LogMessage.SEARCH_USER_BY_ID_SUCCESS);
        MessageLog messageLog = new MessageLog();
        messageLog.setOperLog(LogMessage.SEARCH_USER_BY_ID_SUCCESS, getUserId());
        commonService.pushLogMessage(messageLog);
    }
}