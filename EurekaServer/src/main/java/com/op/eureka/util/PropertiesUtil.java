package com.op.eureka.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
@Component
public class PropertiesUtil {

    private static String userConfigFile = "mail.properties";
    private static PropertiesUtil propertiesUtil = new PropertiesUtil();
    private static final Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    public PropertiesUtil() {
    }

    public PropertiesUtil(String userConfigFile) {
        this.userConfigFile = userConfigFile;
    }

    public static PropertiesUtil setConfigFileName(String configFile) {
        userConfigFile = configFile;
        return propertiesUtil;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getValue(String key) {
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(userConfigFile);
            properties.load(in);
        } catch (Exception e) {
            LOGGER.info("get application.properties is null");
        } finally {
            if (Objects.equals(null, in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String value = null;
        try {
            String valueStr = properties.get(key).toString();
            if (null == valueStr) {
                return null;
            }
            value = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
        } catch (Exception e) {
            System.out.println("charset error,please use utf-8 charset code!");
        }
        if (null == value) {
            System.out.println("notice: you get value is null!");
        }
        return value;
    }

    public static String getUserConfigFile() {
        return userConfigFile;
    }

    public static void setUserConfigFile(String userConfigFile) {
        PropertiesUtil.userConfigFile = userConfigFile;
    }
}
