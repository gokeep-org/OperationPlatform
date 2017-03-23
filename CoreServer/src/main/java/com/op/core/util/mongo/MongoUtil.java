package com.op.core.util.mongo;

import java.util.Objects;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public class MongoUtil {
    private static MongoClient mongoClient;
    private static Gson gson;
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoUtil.class);

    private MongoUtil() {
        if (Objects.equals(null, mongoClient)) {
            mongoClient = new MongoClient();
        }
        if (Objects.equals(null, gson)) {
            gson = new GsonBuilder().serializeNulls().create();
        }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static MongoDatabase getDB(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    public static MongoCollection getCollection(String dbName, String collectionName) {
        return getDB(dbName).getCollection(collectionName);
    }

    public static Document parse(String json) {
        return Document.parse(json);
    }

    public static Document parse(Object o) {
        return Document.parse(gson.toJson(o));
    }

    public static void closeClient() {
        mongoClient.close();
    }

}
