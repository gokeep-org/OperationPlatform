package com.op.core.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/16.
 ****************************************/
public class Md5 {
    private Md5() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Md5.class);

    /**
     * 获取MD5加密秘钥
     * @param pwd
     * @return
     */
    public static String getSercretKey(String pwd) {
        char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = pwd.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOGGER.error("md5 add secret error");
        }
        return null;
    }

    public static Boolean checkSercretIsSuccess(String secretKey, String pwd) {
        if (getSercretKey(pwd).equals(secretKey)) {
            return true;
        }
        return false;
    }
}
