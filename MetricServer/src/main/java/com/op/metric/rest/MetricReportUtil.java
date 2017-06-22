package com.op.metric.rest;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.AdminServlet;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/20.
 ****************************************/
public class MetricReportUtil {
    private static MetricRegistry metrics;
    private static Counter requests;
    private static ConsoleReporter reporter;

    private MetricReportUtil() {
    }

    static {
        metrics = new MetricRegistry();
        reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);

    }

    public static void mark() {

    }

    public static void inc(String name, long incSize) {
        AdminServlet adminServlet;
        requests = metrics.counter(name);
        requests.inc(incSize);
    }

    public static Metric getMetric() {
        return requests;
    }

    public static long getCount(String name) {
        return metrics.counter(name).getCount();
    }
}
