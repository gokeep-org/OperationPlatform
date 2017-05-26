package com.op;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.op.analysis.AnalysisServerBootstrap;
import com.op.analysis.service.MeasureAnalysisService;
import com.op.util.discovery.ServerName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/25.
 ****************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AnalysisServerBootstrap.class)
public class TestMeasure {
    @Autowired
    public MeasureAnalysisService measureAnalysisService;
    @Test
    public void getMeasureHealthInfo(){
        Map map = measureAnalysisService.searchNodeHealthy(ServerName.CORE);
        System.out.println(map);
    }
}
