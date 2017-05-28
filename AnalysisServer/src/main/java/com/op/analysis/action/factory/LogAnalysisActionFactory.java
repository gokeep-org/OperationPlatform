package com.op.analysis.action.factory;

import java.util.Map;

import com.op.analysis.action.log.CommonLogAnalysisAction;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
public class LogAnalysisActionFactory extends BaseActionFactory {
    public static CommonLogAnalysisAction getCommonLogAnalysisAction(String index, String type, Map query) {
        return new CommonLogAnalysisAction(type, query);
    }
}
