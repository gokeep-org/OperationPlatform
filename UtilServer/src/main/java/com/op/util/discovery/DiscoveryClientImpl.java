package com.op.util.discovery;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/14.
 ****************************************/
public class DiscoveryClientImpl implements DiscoveryClient {
    private static Logger LOGGER = LoggerFactory.getLogger(DiscoveryClientImpl.class);
    private static Map<String, ILoadBalancer> namedLBMap = new ConcurrentHashMap<String, ILoadBalancer>();
    public DiscoveryClientImpl(){}
    public String choose(String serverId){
        String serverStr = null;
        try {
            DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) namedLBMap.get(serverId);
            if (lb == null) {
                DefaultClientConfigImpl config = DefaultClientConfigImpl.getClientConfigWithDefaultValues();
                config.setProperty(CommonClientConfigKey.NFLoadBalancerPingInterval, ConfigurationManager.getConfigInstance().getInt("ribbon.NFLoadBalancerPingInterval",20));
                ServerList<DiscoveryEnabledServer> list = new DiscoveryEnabledNIWSServerList(serverId);
                ServerListFilter<DiscoveryEnabledServer> filter = new ServerListSubsetFilter<DiscoveryEnabledServer>();
                lb = LoadBalancerBuilder.<DiscoveryEnabledServer> newBuilder().withDynamicServerList(list)
                        .withServerListFilter(filter).withPing(new PingPort()).withRule(new BestAvailableRule()).withClientConfig(config).buildDynamicServerListLoadBalancer();
                LOGGER.info("NFLoadBalancerPingInterval:" +config.get(CommonClientConfigKey.NFLoadBalancerPingInterval));
                namedLBMap.put(serverId, lb);
            }
            DiscoveryEnabledServer server = (DiscoveryEnabledServer) lb.chooseServer();
            if (server != null) {
                serverStr = server.getInstanceInfo().getIPAddr() + ":" + server.getInstanceInfo().getPort();
            }
        } catch (Throwable t) {
            LOGGER.error("查询服务时异常", t);
        }
        return serverStr;
    }
}
