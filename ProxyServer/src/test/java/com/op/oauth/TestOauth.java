package com.op.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.proxy.ProxyBootstrap;
import com.op.proxy.service.AuthService;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/22.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ProxyBootstrap.class)
public class TestOauth {
    @Autowired
    public AuthService authService;
    @Test
    public void testAccessAuth() {
        authService.checkAccessAuth("92eb060e-c22c-4bf2-ad45-e18d6a95b81b", "/user/user", "POST");
    }


}
