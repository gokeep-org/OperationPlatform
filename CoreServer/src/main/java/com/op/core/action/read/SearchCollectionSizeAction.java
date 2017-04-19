package com.op.core.action.read;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.ReadOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/19.
 ****************************************/
public class SearchCollectionSizeAction extends ItemAction<BaseOutput> {
    private Query query;
    private String collectionName;
    private Long total;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchCollectionSizeAction.class);
    public SearchCollectionSizeAction(Query query, String collectionName) {
        this.query = query;
        this.collectionName = collectionName;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        if (Objects.equals(null, query))
            this.total = (Long) readServices.findCollectionSize(this.collectionName);
        else
            this.total = (Long) readServices.findCollectionSizeByQuery(query, this.collectionName);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        ReadOutput output = new ReadOutput(null, "200", "操作成功");
        output.setTotal(this.total);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search collection size successful");
    }
}
