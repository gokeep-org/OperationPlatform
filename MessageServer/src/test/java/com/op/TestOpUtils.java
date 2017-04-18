package com.op;

import com.op.message.util.OpUtils;

import org.junit.Test;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/17.
 ****************************************/
public class TestOpUtils {
    @Test
    public void testGetEnvValue() {
        String s = OpUtils.getEnvValue("JAVA_HOME");
        System.out.println(s);
    }
}
