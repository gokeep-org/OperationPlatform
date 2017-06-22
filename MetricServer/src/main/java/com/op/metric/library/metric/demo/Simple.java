package com.op.metric.library.metric.demo;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.op.metric.library.metric.MetricsRegistry;
import com.op.metric.library.metric.MetricsRegistryImpl;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/
public class Simple {
    public static void main(String[] args) throws InterruptedException {
        MetricsRegistry metricsRegistry = new MetricsRegistryImpl();
        Meter counter1 = metricsRegistry.meter("aaa");
        Counter counter2 = metricsRegistry.counter("test2_report");
        for (int i =0; i <= 100; i++){
            counter1.mark();
            counter2.inc();
            counter1.mark();
            Thread.sleep(1000);
        }
    }
}
