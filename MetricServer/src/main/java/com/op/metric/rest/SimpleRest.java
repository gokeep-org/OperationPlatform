package com.op.metric.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.antfact.oplate.metrics.api.Registry;
import com.antfact.oplate.metrics.api.RegistryImpl;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/20.
 ****************************************/
@Path("/simple")
@Produces(MediaType.APPLICATION_JSON)
public class SimpleRest {

    Registry register = RegistryImpl.gentInstance();
    //注册并实例化Timer类型度量指标
    Timer latency = register.timer("latency");
    Meter meter = register.meter("meter_test");
    //注册并实例化Counter类型度量指标
    private Counter invokedCounter = register.counter("invokedCounter");

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRest.class);
    //度量
    @GET
    @Path("/test")
    public String doSomething(){
//        final Timer.Context context = latency.time();
        meter.mark();
        try {
            LOGGER.info("计时器计算");
        } finally {
//            context.stop();
//            invokedCounter.inc();
        }
        LOGGER.info(String.valueOf(meter.getCount()));
        LOGGER.info(String.valueOf(meter.getMeanRate()));
        return "OK";
    }
//    MetricRegistry metrics = null;
//    Meter requests = null;
//    public SimpleRest(){
//        if (Objects.equals(null, metrics)){
//           metrics = new MetricRegistry();
//            ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
//                    .convertRatesTo(TimeUnit.SECONDS)
//                    .convertDurationsTo(TimeUnit.MILLISECONDS)
//                    .build();
//            reporter.start(1, TimeUnit.SECONDS);
//            requests = metrics.meter("requests");
//        }
//
//    }

    @GET
    @Path("/test1")
    public String test(){
//        requests.mark();
        return "OK";
    }
}
