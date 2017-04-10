package com.op.es.bean.action.output.log;

import com.op.es.bean.action.output.index.WriteOutput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/7.
 ****************************************/
public class WriteLogOutput extends WriteOutput {
    public WriteLogOutput(int code, String message, String uuid) {
        super(code, message, uuid);
    }

    public WriteLogOutput(int code, String message) {
        super(code, message);
    }

    public WriteLogOutput() {
    }
}
