package com.op.core.action.factory;

import com.op.core.action.read.SearchDocumentAction;
import com.op.core.bean.action.input.SearchInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class ReadActionFactory extends BaseActionFactory {
    public static SearchDocumentAction getSearchDocumentByIdAction(SearchInput input){
        return new SearchDocumentAction(input);
    }

}
