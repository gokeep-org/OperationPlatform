package com.op.oauth.config;

import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

import com.op.oauth.util.OpUtils;
import com.op.oauth.util.PropertiesUtil;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-19
 ****************************************/
@Configuration
public class JettyConfig extends JettyEmbeddedServletContainerFactory {

    private static PropertiesUtil propertiesUtil = new PropertiesUtil("jetty-config.properties");
    private static final String maxThread = propertiesUtil.getValue("server.jetty.maxthread.size");
    private static final String minThread = propertiesUtil.getValue("server.jetty.minthread.size");
    private static final String timout = propertiesUtil.getValue("server.jetty.timeout");
    private static final String queueSize = propertiesUtil.getValue("server.jetty.queue.size");
    private static String serverPort = OpUtils.getEnvValue("SERVER_PORT");
    private static QueuedThreadPool threadPool = new QueuedThreadPool();

    public JettyConfig() {
        setMaxThread();
        setMinThread();
        setTimout();
        setQueueSize();
        setServerPort();
        setThreadPool(threadPool);
    }

    public void setMaxThread() {
        threadPool.setMaxThreads(Integer.parseInt(maxThread));
    }

    public void setMinThread() {
        threadPool.setMinThreads(Integer.parseInt(minThread));
    }

    public void setTimout() {
        threadPool.setIdleTimeout(Integer.parseInt(timout));
    }

    public void setQueueSize() {

    }

    public void setServerPort() {
        
        if(null == serverPort || serverPort.trim().equals("")){
            serverPort = propertiesUtil.getValue("server.jetty.port");
        }
        setPort(Integer.parseInt(serverPort));
    }
}