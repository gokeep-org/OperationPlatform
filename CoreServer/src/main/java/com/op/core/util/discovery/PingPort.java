package com.op.core.util.discovery;

import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/14.
 ****************************************/
public class PingPort implements IPing {
    private static Logger logger = LoggerFactory.getLogger(PingPort.class);
    public boolean isAlive(Server server) {
        logger.trace("检查端口状态,线程名称：" + Thread.currentThread().getName());
        DiscoveryEnabledServer enabledServer = (DiscoveryEnabledServer) server;
        int IpSocketTimeOut= ConfigurationManager.getConfigInstance().getInt("iping.socket.timeout",3000);
        logger.trace("socket超时时间："+IpSocketTimeOut);
        boolean isAlive = false;
        Socket client = new Socket();
        String ip = enabledServer.getInstanceInfo().getIPAddr();
        int port = enabledServer.getInstanceInfo().getPort();
        try {
            SocketAddress socketAddress = new InetSocketAddress(ip,port);
            client.connect(socketAddress,IpSocketTimeOut);
            isAlive = true;
        } catch (Exception e) {
            logger.error("获取端口状态时异常:" + ip + ":" + port, e.getMessage());
            return isAlive;
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    logger.error("client close is error");
                }
            }
        }
        return isAlive;
    }
}
