package com.op.util.gson;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
public class SerializeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializeUtil.class);
    public static Gson gson = new Gson();

    /**
     * 单例花转化方法
     */
    private SerializeUtil() {
        if (Objects.equals(null, gson)) {
            gson = new Gson();
        }
    }

    /**
     * 获取gson对象
     * @return
     */
    public static Gson getGson() {
        return gson;
    }

    /**
     * Map对象转化
     * @param map
     * @return
     */
    public static JsonObject transfromMapToJsonObject(Map map) {
        if (Objects.equals(null, map) || 0 >= map.size()) {
            return null;
        }
        String str = gson.toJson(map);
        return gson.fromJson(str, JsonObject.class);
    }

    /**
     * Object转化为String
     * @param o
     * @return
     */
    public static String transfromObjectToString(Object o) {
        if (Objects.equals(null, o)) {
            return null;
        }
        return gson.toJson(o);
    }

    /**
     * String转化为对象
     * @param json
     * @param classes
     * @return
     */
    public static Object transfromStringToObject(String json, Class classes) {
        if (null == json) {
            return null;
        }
        return gson.fromJson(json, classes);
    }


    /**
     * string 转化为List
     * @param json
     * @return
     */
    public static Object transfromStringToList(String json) {
        if (null == json) {
            return null;
        }
        JsonObject obj = (JsonObject) transfromStringToObject(json, JsonObject.class);
        return gson.fromJson(obj.getAsJsonArray("list"), List.class);
    }
}
