package com.op.core.action.factory;

import com.op.core.action.write.DeleteAction;
import com.op.core.action.write.InsertAction;
import com.op.core.action.write.InsertsAction;
import com.op.core.bean.action.input.write.InsertInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class WriteActionFactory extends BaseActionFactory {
    public static InsertAction getInsertAction(InsertInput input) {
        return new InsertAction(input);
    }

    public static InsertsAction getInsertsAction(InsertInput input) {
        return new InsertsAction(input);
    }

    public static DeleteAction getDeleteAction() {
        return null;
    }
}
