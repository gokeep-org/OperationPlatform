package com.op.core.util.mongo;


import java.util.ArrayList;
import java.util.Objects;

import org.bson.BSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.mongodb.util.JSON;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/27.
 ****************************************/
public class SerializeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializeUtil.class);
    public static Gson gson = new Gson();

    private SerializeUtil() {
        if (Objects.equals(null, gson)) {
            gson = new Gson();
        }
    }

    public static Gson getGson() {
        return gson;
    }

    public static BSONObject parseToBson(Object o) {
        String json = gson.toJson(o);
        return (BSONObject) JSON.parse(json);
    }

    public static String getCollectionNameByClass(Class classes) {
        if (classes.isInstance(new ArrayList())) {

        }
        return classes.getSimpleName().toLowerCase();
    }

}
