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
public class Start {
    public static void main(String[] args) {
//        ThreadImportMondo t1 = new ThreadImportMondo(0, 100000);
//        ThreadImportMondo t2 = new ThreadImportMondo(100001, 200000);
//        ThreadImportMondo t3 = new ThreadImportMondo(200001, 300000);
//        ThreadImportMondo t4 = new ThreadImportMondo(300001, 400000);
//        ThreadImportMondo t5= new ThreadImportMondo(400001, 500000);
//        ThreadImportMondo t6 = new ThreadImportMondo(500001, 600000);
//        ThreadImportMondo t7 = new ThreadImportMondo(600001, 700000);
//        ThreadImportMondo t8 = new ThreadImportMondo(600001, 800000);
//        ThreadImportMondo t9 = new ThreadImportMondo(800001, 900000);
//        ThreadImportMondo t10 = new ThreadImportMondo(900001, 1000000);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        t9.start();
//        t10.start();
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("op");
        MongoCollection<Document> dbCollection = db.getCollection("user");
        long startTime = System.currentTimeMillis();
        Document document1 = new Document();
        document1.put("aaa", 111);
        document1.put("bbb", 222);
        dbCollection.insertOne(document1);
        dbCollection.find();
        long endTime = System.currentTimeMillis();
        System.out.println("共计用时： " + (endTime - startTime));
        client.close();
    }
}
