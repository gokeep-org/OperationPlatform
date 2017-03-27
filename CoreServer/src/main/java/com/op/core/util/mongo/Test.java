package com.op.core.util.mongo;

import com.op.core.bean.entity.user.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
public class Test {
    public static void main(String[] args) {
        System.out.println(SerializeUtil.getCollectionNameByClass(User.class));
    }
}
