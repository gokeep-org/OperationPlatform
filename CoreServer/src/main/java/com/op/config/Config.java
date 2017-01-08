//package com.op.config;
//
//import org.dom4j.Document;
//import org.dom4j.Element;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.List;
//
///****************************************
// * Copyright (c) xuning.
// * 尊重版权，禁止抄袭!
// * 如有违反，必将追究其法律责任.
// * @Auther is xuning on 2017/1/8.
// ****************************************/
//public class Config {
//    private static Logger logger = LoggerFactory.getLogger(Config.class);
//    private static final String DEFAULT_CONFIG_FILE = "application-config.xml";
//    private static final String BASE_CONFIG_FILE = "application-base.conf";
//    protected static volatile Config config = null;
//    private Document configDocument;
//
//    public String getServiceName(Object defaultValue) {
//        String name = null;
//        if(defaultValue != null) {
//            name = defaultValue.toString();
//        }
//
//        Element e = this.getElement("/configuration/name");
//        if(e != null) {
//            name = e.getTextTrim();
//        }
//
//        return name;
//    }
//
//    public int getRetryTime() {
//        int retry = 1;
//        Element e = this.getElement("/configuration/retries");
//        if(e != null) {
//            try {
//                retry = Integer.parseInt(e.getTextTrim());
//            } catch (NumberFormatException var4) {
//                ;
//            }
//        }
//
//        return retry;
//    }
//
//    public long getRestartWindow() {
//        return (long)((Integer)getNumber("/configuration/restart_window", Integer.valueOf(10000))).intValue();
//    }
//
//    public long getRestartSleepTime() {
//        return (long)((Integer)getNumber("/configuration/restart_sleep", Integer.valueOf(10000))).intValue();
//    }
//
//    public static String getString(Element e, String defaultValue, String hint) {
//        if(e == null) {
//            logger.warn("no [config: {}] found, default to [value: {}]");
//            return defaultValue;
//        } else {
//            return realGetString(e.getText(), defaultValue, hint);
//        }
//    }
//
//    public static String getString(Element e, String attribute, String defaultValue, String hint) {
//        if(e == null) {
//            return defaultValue;
//        } else {
//            return realGetString(e.attributeValue(attribute), defaultValue, hint);
//        }
//    }
//
//    public static String getString(String xpath, String defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        return getString(e, defaultValue, xpath);
//    }
//
//    public static String getString(String xpath, String attribute, String defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        String hint = xpath + "@" + attribute;
//        return getString(e, attribute, defaultValue, hint);
//    }
//
//    public static String realGetString(String s, String defaultValue, String hint) {
//        if(s == null) {
//            return defaultValue;
//        } else {
//            return s;
//        }
//    }
//
//    public static <T> T getNumber(Element e, T defaultValue, String hint) {
//        if(e == null) {
//            return defaultValue;
//        } else {
//            return realGetNumber(e.getTextTrim(), defaultValue, hint);
//        }
//    }
//
//    public static <T> T getNumber(Element e, String attribute, T defaultValue, String hint) {
//        if(e == null) {
//            return defaultValue;
//        } else {
//            return realGetNumber(e.attributeValue(attribute), defaultValue, hint);
//        }
//    }
//
//    public static <T> T getNumber(String xpath, T defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        return getNumber(e, defaultValue, xpath);
//    }
//
//    public static <T> T getNumber(String xpath, String attribute, T defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        String hint = xpath + "@" + attribute;
//        return getNumber(e, attribute, defaultValue, hint);
//    }
//
//    public static <T> T realGetNumber(String s, T defaultValue, String hint) {
//        Object e = null;
//        if(s == null) {
//            return defaultValue;
//        } else {
//            try {
//                Method ee = defaultValue.getClass().getMethod("valueOf", new Class[]{String.class});
//                if(ee != null) {
//                    return (T) ee.invoke((Object)null, new Object[]{s.trim()});
//                }
//            } catch (InvocationTargetException var5) {
//                e = var5.getTargetException();
//            } catch (Exception var6) {
//                e = var6;
//            }
//
//            if(e == null) {
//            } else {
//            }
//
//            return defaultValue;
//        }
//    }
//
//    public static boolean getBoolean(Element e, boolean defaultValue, String hint) {
//        if(e == null) {
//            return defaultValue;
//        } else {
//            return realGetBoolean(e.getTextTrim(), defaultValue, hint);
//        }
//    }
//
//    public static boolean getBoolean(Element e, String attribute, boolean defaultValue, String hint) {
//        if(e == null) {
//            return defaultValue;
//        } else {
//            return realGetBoolean(e.attributeValue(attribute), defaultValue, hint);
//        }
//    }
//
//    public static boolean getBoolean(String xpath, boolean defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        return getBoolean(e, defaultValue, xpath);
//    }
//
//    public static boolean getBoolean(String xpath, String attribute, boolean defaultValue) {
//        Element e = getConfig().getElement(xpath);
//        String hint = xpath + "@" + attribute;
//        return getBoolean(e, attribute, defaultValue, hint);
//    }
//
//    public static boolean realGetBoolean(String s, boolean defaultValue, String hint) {
//        if(s == null) {
//            return defaultValue;
//        } else {
//            return Boolean.valueOf(s).booleanValue();
//        }
//    }
//
//    private Config(Document doc) {
//        this.configDocument = doc;
//    }
//
//    private static void loadConfig(String file) throws IOException, DocumentException {
//        InputStream is = Config.class.getClassLoader().getResourceAsStream(file);
//        Throwable var2 = null;
//
//        try {
//            if(is == null) {
//                logger.error((MyUUID)null, "No [config: {}] found in conf directory", new Object[]{file});
//                System.exit(1);
//            }
//
//            SAXReader reader = new SAXReader();
//            Document doc = reader.read(is);
//            config = new Config(doc);
//            is.close();
//        } catch (Throwable var12) {
//            var2 = var12;
//            throw var12;
//        } finally {
//            if(is != null) {
//                if(var2 != null) {
//                    try {
//                        is.close();
//                    } catch (Throwable var11) {
//                        var2.addSuppressed(var11);
//                    }
//                } else {
//                    is.close();
//                }
//            }
//
//        }
//
//    }
//
//    private static void loadConfig() throws Exception {
//        String configFileName = "application-config.xml";
//
//        try {
//            BufferedReader e = new BufferedReader(new InputStreamReader(Config.class.getClassLoader().getResourceAsStream("application-base.conf")));
//            Throwable var2 = null;
//
//            try {
//                configFileName = e.readLine();
//                if(configFileName == null) {
//                    throw new Exception("No content in base config file");
//                }
//            } catch (Throwable var13) {
//                var2 = var13;
//                throw var13;
//            } finally {
//                if(e != null) {
//                    if(var2 != null) {
//                        try {
//                            e.close();
//                        } catch (Throwable var12) {
//                            var2.addSuppressed(var12);
//                        }
//                    } else {
//                        e.close();
//                    }
//                }
//
//            }
//        } catch (Exception var16) {
//            logger.warn((MyUUID)null, "read base configure error, default to read [config_file: {}]", new Object[]{"application-config.xml"});
//        }
//
//        try {
//            loadConfig(configFileName);
//        } catch (Exception var14) {
//            if(configFileName.equals("application-config.xml")) {
//                throw var14;
//            }
//
//            logger.warn((MyUUID)null, var14, "read [config_file: {}] error, default to [real_config_file: {}]", new Object[]{configFileName, "application-config.xml"});
//            loadConfig("application-config.xml");
//        }
//
//    }
//
//    public static Config getConfig() {
//        try {
//            if(config == null) {
//                Class e = Config.class;
//                synchronized(Config.class) {
//                    if(config == null) {
//                        loadConfig();
//                        return config;
//                    }
//                }
//            }
//        } catch (Exception var3) {
//            throw new InternalException("configuration error", var3);
//        }
//
//        return config;
//    }
//
//    public Element getElement(String xpath) {
//        return (Element)this.configDocument.selectSingleNode(xpath);
//    }
//
//    public List<Element> getElements(String xpath) {
//        return this.configDocument.selectNodes(xpath);
//    }
//}
