package com.op.config;

import com.op.util.PropertiesUtil;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-19
 ****************************************/
@Configuration
public class JettyConfig extends JettyEmbeddedServletContainerFactory {

    private static PropertiesUtil propertiesUtil = new PropertiesUtil("app-config.properties");
    private static final String maxThread = propertiesUtil.getValue("server.jetty.maxthread.size");
    private static final String minThread = propertiesUtil.getValue("server.jetty.minthread.size");
    private static final String timout = propertiesUtil.getValue("server.jetty.timeout");
    private static final String queueSize = propertiesUtil.getValue("server.jetty.queue.size");
    private static final String serverPort = propertiesUtil.getValue("server.jetty.port");
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
        threadPool.setMaxThreads(2000);
    }

    public void setMinThread() {
        threadPool.setMinThreads(20);
    }

    public void setTimout() {
        threadPool.setIdleTimeout(30000);
    }

    public void setQueueSize() {
//        threadPool.setQueue();
//        int capacity = Math.max(60000, 8);
//        Queue queue = new BlockingArrayQueue(capacity, capacity);
//        threadPool.setQueue((BlockingQueue<Runnable>) queue);

    }

    public void setServerPort() {
        setPort(9090);
    }

}