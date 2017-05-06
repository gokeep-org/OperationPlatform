package com.op.util.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/6.
 ****************************************/
public class ReflectUtil {
    /**
     * 反射Util取出所有的字段key-value
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);

    private ReflectUtil() {
    }

    public static Map<String, Object> reflect(Object obj) {
        if (Objects.equals(null, obj)) {
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object fieldValue = null;
            try {
                fieldValue = field.get(obj);
            } catch (IllegalAccessException e) {
                LOGGER.error("reflect class get value is error");
            }
            map.put(fieldName, fieldValue);
        }
        return map;
    }
//
//    public static void main(String[] args) throws IllegalAccessException {
//        Person p = new Person();
//        p.setId(0);
//        p.setName("张三");
//        Set<Map.Entry<String, Object>> entries = reflect(p).entrySet();
//
//        for (Map.Entry<String, Object> entry : entries) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//    }
}