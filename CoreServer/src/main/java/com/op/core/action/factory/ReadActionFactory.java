package com.op.core.action.factory;

import org.springframework.data.mongodb.core.query.Query;

import com.op.core.action.read.SearchCollectionSizeAction;
import com.op.core.action.read.SearchDocumentAction;
import com.op.core.action.read.SearchDocumentBytermAction;
import com.op.core.action.read.SearchRepeatCollectionNameAction;
import com.op.core.bean.action.input.SearchInput;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-3-28
 ****************************************/
public class ReadActionFactory extends BaseActionFactory {
    public static SearchDocumentAction getSearchDocumentByIdAction(SearchInput input) {
        return new SearchDocumentAction(input);
    }

    public static SearchDocumentBytermAction getSearchDocumentBytermAction(SearchInput input, int pageNow, int pageSize, String field, String order) {
        return new SearchDocumentBytermAction(input, pageNow, pageSize, field, order);
    }

    public static SearchCollectionSizeAction getSearchCollectionSizeAction(Query query, String collectionName) {
        return new SearchCollectionSizeAction(query, collectionName);
    }

    public static SearchRepeatCollectionNameAction getSearchRepeatCollectionNameAction(String name, String collectionName) {
        return new SearchRepeatCollectionNameAction(name, collectionName);
    }
}
