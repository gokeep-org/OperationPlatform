package com.op.core.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public class ThreadImportMondo extends Thread {
    private int start;
    private int end;

    public ThreadImportMondo(int startPoint, int endPoint) {
        this.start = startPoint;
        this.end = endPoint;
    }

    @Override
    public void run() {
        MongoClient client = new MongoClient();
        for (int i = start; i < end; i++) {
            MongoDatabase db = client.getDatabase("op");
            MongoCollection<Document> dbCollection = db.getCollection("user");
            long startTime = System.currentTimeMillis();
            Document document = new Document();
            Test test = new Test();
            test.put("aaaa", "bbbb");
            test.setName("xiaoningning");
            dbCollection.insertOne(test);
            long endTime = System.currentTimeMillis();
            System.out.println("共计用时： " + (endTime - startTime));
        }
        client.close();
    }
}
