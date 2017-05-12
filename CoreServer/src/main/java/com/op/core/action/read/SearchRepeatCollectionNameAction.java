package com.op.core.action.read;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.ReadOutput;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/3.
 ****************************************/
public class SearchRepeatCollectionNameAction extends ItemAction<BaseOutput> {
    private String name;
    private String collectionName;
    private List list;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchRepeatCollectionNameAction.class);

    public SearchRepeatCollectionNameAction(String name, String collectionName) {
        this.name = name;
        this.collectionName = collectionName;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == name) {
            throw new OperationPlatformException("search repeat name is null");
        }
    }

    @Override
    protected void start() throws Exception {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("name").is(name), Criteria.where("username").is(name));
        this.list = (List) readServices.findByQuery(new Query(criteria), collectionName);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        ReadOutput readOutput = new ReadOutput("200", "操作成功");
        readOutput.setList(this.list);
        return readOutput;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search repeat customer is successful");
    }
}