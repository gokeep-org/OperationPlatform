package com.op.core.action.write;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.UpdateInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.WriteOutput;
import com.op.util.exception.OperationPlatformException;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class UpdateAction extends ItemAction<BaseOutput> {
    private String collectionName;
    private Map body;
    private List<String> ids;
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateAction.class);

    public UpdateAction(UpdateInput input) {
        this.ids = input.getIds();
        this.body = (Map) input.getO();
        this.collectionName = input.getCollectionName();
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {
        if(Objects.equals(null, this.body)||0>=this.body.size()||0>=this.ids.size())
            throw new OperationPlatformException("update body is must not null");
    }

    @Override
    protected void start() throws Exception {
        this.ids.stream().forEach(id->{
            writeService.updateById(id, this.body, this.collectionName);
        });
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        WriteOutput output = new WriteOutput();
        output.setCode("200");
        output.setMessage("操作成功");
        output.setSuccess(true);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("update a obj is successful");
    }
}
