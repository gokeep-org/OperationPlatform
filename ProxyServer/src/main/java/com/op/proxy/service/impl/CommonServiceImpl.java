package com.op.proxy.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.proxy.service.CommonService;
import com.op.util.bean.UriPath;
import com.op.util.bean.log.MessageLog;
import com.op.util.common.RequestUtil;
import com.op.util.discovery.DiscoveryVip;
import com.op.util.discovery.ServerName;
import com.op.util.exception.OperationPlatformException;
import com.op.util.requests.Requests;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private Requests requests;
    @Autowired
    private DiscoveryVip discoveryVip;
    @Autowired
    private HttpServletRequest httpServletRequest;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Override
    public void pushLogMessage(MessageLog log) {
        try {
            String messageServer = discoveryVip.choose(ServerName.MESSAGE);
            requests.post(messageServer + UriPath.MESSAGE + "/es/push", log, getHeaders());
        } catch (OperationPlatformException e) {
            LOGGER.error("push message to rabbitmq found error");
        }
    }

    public Map<String, String> getHeaders() {
        String userId = httpServletRequest.getHeader("user_id");
        return RequestUtil.setUserIdToRequest(userId);
    }
}