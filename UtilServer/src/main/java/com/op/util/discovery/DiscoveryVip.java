package com.op.util.discovery;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-4-16
 ****************************************/
public interface DiscoveryVip {
    /**
     * 根据ServiceId获取服务的IP:PORT
     * @param serverId
     * @return
     */
    public String choose(String serverId);
}
