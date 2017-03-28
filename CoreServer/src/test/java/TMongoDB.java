//import org.bson.Document;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.google.gson.Gson;
//import com.mongodb.BasicDBObject;
//import com.mongodb.Block;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBObject;
//import com.mongodb.MongoClient;
//import com.mongodb.WriteResult;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.op.core.bean.entity.user.User;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/3/23.
// ****************************************/
//public class TMongoDB {
//    private MongoClient client;
//
//    @Before
//    public void before(){
//        this.client = new MongoClient();
//    }
//
//    @Test
//    public void testSimpleInsertDocument() {
//        client.getDatabaseNames().forEach(e -> System.out.println(e));
//        DB db = client.getDB("op");
//        DBCollection dbCollection = db.getCollection("user");
//        long startTime = System.currentTimeMillis();
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("name", "李四");
//        dbObject.put("age", 34);
//        DBObject info = new BasicDBObject();
//        info.put("part", "开发部");
//        info.put("inter", false);
//        dbObject.put("info", info);
//        WriteResult result = dbCollection.insert(dbObject);
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("共计用时： " + (endTime - startTime));
//        client.close();
//    }
//    @Test
//    public void newInsertDb() {
//        MongoDatabase db = client.getDatabase("op");
//        MongoCollection<Document> dbCollection = db.getCollection("user");
//        long startTime = System.currentTimeMillis();
//        Document document = new Document();
//        document.put("aaa", 111);
//        document.put("bbb", false);
//        dbCollection.insertOne(document);
//        long endTime = System.currentTimeMillis();
//        System.out.println("共计用时： " + (endTime - startTime));
//        client.close();
//    }
//
//    @Test
//    public void simpleSearch(){
//        MongoDatabase db = client.getDatabase("op");
//        MongoCollection<Document> dbCollection = db.getCollection("user");
//        long startTime = System.currentTimeMillis();
//        FindIterable<Document> documents = dbCollection.find();
//        documents.forEach((Block<? super Document>) e->{
//            System.out.println(e.toJson());
//        });
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("共计用时： " + (endTime - startTime));
//        client.close();
//    }
//
//    @Test
//    public void insertCustomObject(){
//        MongoDatabase db = client.getDatabase("op");
//        MongoCollection<Document> dbCollection = db.getCollection("user");
//        long startTime = System.currentTimeMillis();
//        User user = new User();
//        user.setUsername("徐宁");
//        user.setPassword("shuaige");
//        String json = new Gson().toJson(user);
//        dbCollection.insertOne(Document.parse(json));
//        long endTime = System.currentTimeMillis();
//        System.out.println("共计用时： " + (endTime - startTime));
//        client.close();
//    }
//
//
//}
