package com.op.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class OpUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(OpUtils.class);
	private OpUtils() {
	}

	//验证字符串是不是空
	public static Boolean checkStringIsNull(String string) {
		if (null == string || string.trim().equals("")) {
			return true;
		}
		return false;
	}

	public static Boolean checkObjectIsNull(Object obj){
		if (!Objects.equals(null, obj)){
			return false;
		}
		try{
			List list=(List) obj;
			if (list.size() > 0){
				return false;
			}
		}catch (Exception e){
			LOGGER.info("check obj is null transfrom list is faile");
		}
		return true;
	}
}
