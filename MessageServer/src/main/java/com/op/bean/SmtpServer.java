package com.op.bean;

import com.op.util.PropertiesUtil;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/8.
 ****************************************/
public class SmtpServer {

    private static String smtpHost= PropertiesUtil.getValue("spring.mail.host");
    private static String smtpProt= PropertiesUtil.getValue("spring.mail.port");
    private static String smtpUsername= PropertiesUtil.getValue("spring.mail.username");
    private static String smtpPassword= PropertiesUtil.getValue("spring.mail.password");
    private static String smtpEncoding= PropertiesUtil.getValue("spring.mail.default-encoding");
    private static String protocolType= PropertiesUtil.getValue("spring.mail.protocol");
    private static String smtpAuth= PropertiesUtil.getValue("spring.mail.properties.mail.smtp.auth");
    private static String smtpStarttlsEnable= PropertiesUtil.getValue("spring.mail.properties.mail.smtp.starttls.enable");
    private static SmtpServer smtpServer=new SmtpServer();
    private SmtpServer(){}

    public static String getSmtpHost() {
        return smtpHost;
    }

    public static void setSmtpHost(String smtpHost) {
        SmtpServer.smtpHost = smtpHost;
    }

    public static String getSmtpProt() {
        return smtpProt;
    }

    public static void setSmtpProt(String smtpProt) {
        SmtpServer.smtpProt = smtpProt;
    }

    public static String getSmtpUsername() {
        return smtpUsername;
    }

    public static void setSmtpUsername(String smtpUsername) {
        SmtpServer.smtpUsername = smtpUsername;
    }

    public static String getSmtpPassword() {
        return smtpPassword;
    }

    public static void setSmtpPassword(String smtpPassword) {
        SmtpServer.smtpPassword = smtpPassword;
    }

    public static String getSmtpEncoding() {
        return smtpEncoding;
    }

    public static void setSmtpEncoding(String smtpEncoding) {
        SmtpServer.smtpEncoding = smtpEncoding;
    }

    public static String getProtocolType() {
        return protocolType;
    }

    public static void setProtocolType(String protocolType) {
        SmtpServer.protocolType = protocolType;
    }

    public static String getSmtpAuth() {
        return smtpAuth;
    }

    public static void setSmtpAuth(String smtpAuth) {
        SmtpServer.smtpAuth = smtpAuth;
    }

    public static String getSmtpStarttlsEnable() {
        return smtpStarttlsEnable;
    }

    public static void setSmtpStarttlsEnable(String smtpStarttlsEnable) {
        SmtpServer.smtpStarttlsEnable = smtpStarttlsEnable;
    }

    public SmtpServer getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(SmtpServer smtpServer) {
        this.smtpServer = smtpServer;
    }
}
