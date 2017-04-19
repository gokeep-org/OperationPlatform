package com.op.core.action.read;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.google.gson.JsonObject;
import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.SearchInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.ReadOutput;
import com.op.core.exception.OperationPlatformException;
import com.op.util.gson.SerializeUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/19.
 ****************************************/
public class SearchDocumentBytermAction extends ItemAction<BaseOutput> {
    private String collectionNmae;
    private Map term;
    private String logic;
    private Map res;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDocumentBytermAction.class);

    public SearchDocumentBytermAction(SearchInput input) {
        this.collectionNmae = input.getCollectionName();
        this.term = input.getTerm();
        this.logic = input.getLogic();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (Objects.equals(null, collectionNmae)) {
            throw new OperationPlatformException("collection name is null");
        }
    }

    @Override
    protected void start() throws Exception {
        Query query = new Query();
        Criteria criteria = new Criteria();
        Iterator<Map.Entry<String, Object>> entries = term.entrySet().iterator();
        switch (logic) {
            case "and": {
                for (Iterator<Map.Entry<String, Object>> it = entries; it.hasNext(); ) {
                    it.forEachRemaining(e -> {
                        criteria.where(e.getKey()).is(e.getValue());
                    });
                }
                break;
            }
            case "or": {
                break;
            }
            default: {
                break;
            }
        }
        res = (Map) readServices.findByQuery(query.addCriteria(criteria), collectionNmae);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        JsonObject result = SerializeUtil.transfromMaptoJsonObject(res);
        ReadOutput output = new ReadOutput(result, "200", "操作成功");
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search by term is successful");
    }
}