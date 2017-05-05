package com.op.core.action.read;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.op.core.action.item.ItemAction;
import com.op.core.bean.action.input.SearchInput;
import com.op.core.bean.action.output.BaseOutput;
import com.op.core.bean.action.output.ReadOutput;
import com.op.core.exception.OperationPlatformException;

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
    private List<Map> res;
    private int pageNow;
    private int pageSize;
    private String field;
    private String order;
    private long collectionSize;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDocumentBytermAction.class);

    public SearchDocumentBytermAction(SearchInput input, int pageNow, int pageSize, String field, String order) {
        this.collectionNmae = input.getCollectionName();
        this.term = input.getTerm();
        this.logic = input.getLogic();
        this.pageNow = pageNow;
        this.pageSize = pageSize;
        this.field = field;
        this.order = order;
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
//        Iterator<Map.Entry<String, Object>> entries = term.entrySet().iterator();
//
//        for (Iterator<Map.Entry<String, Object>> it = entries; it.hasNext(); ) {
//            it.forEachRemaining(e -> {
//                criteria.where(e.getKey()).is(e.getValue());
//            });
//        }
//        query.addCriteria(criteria);
        this.collectionSize = (long) readServices.findCollectionSize(this.collectionNmae);
        query.limit(pageSize).skip((pageNow - 1) * pageSize);
        if (this.order.equals("descend")) {
            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, this.field)));
        } else {
            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, this.field)));
        }
        res = (List<Map>) readServices.findByQuery(query, collectionNmae);
    }

    @Override
    protected BaseOutput formatOutput() throws Exception {
        ReadOutput output = new ReadOutput("200", "操作成功");
        output.setList(res);
        output.setTotal(this.collectionSize);
        return output;
    }

    @Override
    protected void logSyncAction() throws Exception {
        LOGGER.info("search by term is successful");
    }
}