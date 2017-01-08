//package com.op.util;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.TypeAdapterFactory;
//
//import java.util.*;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/1/8.
// ****************************************/
//public class GsonUtil {
//    private static Gson gson;
//    private static Gson prettyGson;
//
//    public GsonUtils() {
//    }
//
//    private static Map<Class<?>, Object> getSerializes() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        HashMap result = new HashMap();
//        List elements = Config.getConfig().getElements("/configuration/serializes/serialize");
//        if(elements != null) {
//            Iterator var2 = elements.iterator();
//
//            while(var2.hasNext()) {
//                Element element = (Element)var2.next();
//                String className = element.attributeValue("type");
//                String serializerName = element.attributeValue("serailizer");
//                result.put(Class.forName(className), Class.forName(serializerName).newInstance());
//            }
//        }
//
//        return result;
//    }
//
//    private static List<Object> getFactories() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        ArrayList result = new ArrayList();
//        List elements = Config.getConfig().getElements("/configuration/serializes/factory");
//        if(elements != null) {
//            Iterator var2 = elements.iterator();
//
//            while(var2.hasNext()) {
//                Element element = (Element)var2.next();
//                String factoryName = element.attributeValue("class");
//                result.add(Class.forName(factoryName).newInstance());
//            }
//        }
//
//        return result;
//    }
//
//    public static Gson getGson() throws Exception {
//        if(gson == null) {
//            Class var0 = GsonUtils.class;
//            synchronized(GsonUtils.class) {
//                if(gson == null) {
//                    GsonBuilder builder = new GsonBuilder();
//                    Map serializers = getSerializes();
//                    Iterator factories = serializers.keySet().iterator();
//
//                    while(factories.hasNext()) {
//                        Class clazz = (Class)factories.next();
//                        builder.registerTypeAdapter(clazz, serializers.get(clazz));
//                    }
//
//                    builder.registerTypeAdapter(MyUUID.class, new MyUUIDSerializer());
//                    List factories1 = getFactories();
//                    Iterator clazz1 = factories1.iterator();
//
//                    while(clazz1.hasNext()) {
//                        Object factory = clazz1.next();
//                        if(factory instanceof TypeAdapterFactory) {
//                            builder.registerTypeAdapterFactory((TypeAdapterFactory)factory);
//                        }
//                    }
//
//                    gson = builder.create();
//                }
//            }
//        }
//
//        return gson;
//    }
//
//    public static Gson getPrettyGson() throws Exception {
//        if(prettyGson == null) {
//            Class var0 = GsonUtils.class;
//            synchronized(GsonUtils.class) {
//                if(prettyGson == null) {
//                    GsonBuilder builder = new GsonBuilder();
//                    Map serializers = getSerializes();
//                    Iterator factories = serializers.keySet().iterator();
//
//                    while(factories.hasNext()) {
//                        Class clazz = (Class)factories.next();
//                        builder.registerTypeAdapter(clazz, serializers.get(clazz));
//                    }
//
//                    builder.registerTypeAdapter(MyUUID.class, new MyUUIDSerializer());
//                    List factories1 = getFactories();
//                    Iterator clazz1 = factories1.iterator();
//
//                    while(clazz1.hasNext()) {
//                        Object factory = clazz1.next();
//                        if(factory instanceof TypeAdapterFactory) {
//                            builder.registerTypeAdapterFactory((TypeAdapterFactory)factory);
//                        }
//                    }
//
//                    builder.setPrettyPrinting();
//                    prettyGson = builder.create();
//                }
//            }
//        }
//
//        return prettyGson;
//    }
//}
