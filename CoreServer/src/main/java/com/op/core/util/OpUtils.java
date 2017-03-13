package com.op.core.util;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class OpUtils {
	private OpUtils() {
	}

	//验证字符串是不是空
	public static Boolean checkStringIsNull(String string) {
        return null == string || string.trim().equals("");
    }
}
