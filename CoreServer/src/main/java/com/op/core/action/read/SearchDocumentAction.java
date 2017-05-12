package com.op.core.action.read;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.SearchInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.ReadOutput;
import com.op.util.exception.OperationPlatformException;
import com.op.util.gson.SerializeUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/18.
 ****************************************/
public class SearchDocumentAction extends ItemAction<BaseOutput> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDocumentAction.class);
    private String collectionNmae;
    private String id;
    private Map res;

    public SearchDocumentAction(SearchInput input) {
        this.id = input.getId();
        this.collectionNmae = input.getCollectionName();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if (null == this.id){
            throw new OperationPlatformException("search obj id is must not null");
        }
    }

    @Override
    protected void start() throws Exception {
        res = (Map<String, Object>) readServices.findOneById(this.id, this.collectionNmae);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        JsonObject result = SerializeUtil.transfromMapToJsonObject(res);
        ReadOutput output = new ReadOutput(result, "200", "操作成功");
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search a obj is successful, id:" + id);
    }
}
