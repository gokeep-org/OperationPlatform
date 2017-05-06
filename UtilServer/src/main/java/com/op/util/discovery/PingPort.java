package com.op.util.discovery;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/14.
 ****************************************/
public class PingPort implements IPing {
    private static Logger logger = LoggerFactory.getLogger(PingPort.class);

    public boolean isAlive(Server server) {
        DiscoveryEnabledServer enabledServer = (DiscoveryEnabledServer) server;
        int IpSocketTimeOut = ConfigurationManager.getConfigInstance().getInt("iping.socket.timeout", 3000);
        boolean isAlive = false;
        Socket client = new Socket();
        String ip = enabledServer.getInstanceInfo().getIPAddr();
        int port = enabledServer.getInstanceInfo().getPort();
        try {
            SocketAddress socketAddress = new InetSocketAddress(ip, port);
            client.connect(socketAddress, IpSocketTimeOut);
            isAlive = true;
        } catch (Exception e) {
            logger.error("get port status is exception " + ip + ":" + port, e.getMessage());
            return isAlive;
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    logger.error("get vip is error, because client may not exist or not register");
                }
            }
        }
        return isAlive;
    }
}
