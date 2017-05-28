package com.op.analysis.action.log;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.op.analysis.action.item.ItemAction;
import com.op.analysis.bean.action.output.SearchOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/27.
 ****************************************/
public class CommonLogAnalysisAction extends ItemAction<SearchOutput> {
    private String index;
    private String type;
    private Map query;
    private Map result;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonLogAnalysisAction.class);
    public CommonLogAnalysisAction( String type, Map query) {
        this.index = "log";
        this.type = type;
        this.query = query;
    }

    @Override
    protected void permissionValidate() throws Exception {

    }

    @Override
    protected void additionalValidate() throws Exception {

    }

    @Override
    protected void start() throws Exception {
        this.result = logAnalysisService.commonLogAnalysis(this.index, this.type, this.query);
    }

    @Override
    protected SearchOutput formatOutput() throws Exception {
        SearchOutput output = new SearchOutput();
        output.setResult(this.result);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("common log analysis is successful");
    }
}
