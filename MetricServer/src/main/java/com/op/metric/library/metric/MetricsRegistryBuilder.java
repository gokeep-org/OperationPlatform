package com.op.metric.library.metric;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/

/**
 * 获取单例注册器实例
 */
public class MetricsRegistryBuilder {
    /**
     * 获取注册实例
     */
    private static MetricsRegistryBuilder metricsRegistryFactory;
    private static MetricRegistry metricRegistry;

    static {
        if (Objects.equals(null, metricsRegistryFactory))
            metricsRegistryFactory = new MetricsRegistryBuilder();
        if (Objects.equals(null, metricRegistry))
            metricRegistry = new MetricRegistry();
    }

    /**
     * 只能被实例化一次
     */
    private MetricsRegistryBuilder() {
    }

    public static MetricRegistry getMetricRegistry() {
        switch (MetricsConfig.REPORT_TYPE) {
            case ReportType.CONSOLE:
                startConsoleReporter(MetricsConfig.PERIOD);
                break;
            case ReportType.FLUME:
                startFlumeReport(MetricsConfig.PERIOD, MetricsConfig.FLUME_RECEIVE_URL);
                break;
            case ReportType.CSV:
                startCSVReport(MetricsConfig.PERIOD);
                break;
            case ReportType.SLF4J:
                startSlf4jReport(MetricsConfig.PERIOD, MetricsConfig.SLF4J_LOG_PATH);
                break;
            case ReportType.HTTP:
                startHttpReport(MetricsConfig.PERIOD);
                break;
            default:
                startConsoleReporter(MetricsConfig.PERIOD);
                break;
        }
        return metricsRegistryFactory.metricRegistry;
    }

    public static MetricsRegistryBuilder getCustomerMetricRegistry() {
        return metricsRegistryFactory;
    }

    /**
     * 启动控制台度量报告
     * @param period
     */
    public static void startConsoleReporter(long period) {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(period, TimeUnit.SECONDS);
    }


    /**
     * 启动SLF4J度量报告
     * @param period
     * @param logPath
     */
    public static void startSlf4jReport(long period, String logPath) {
    }

    /**
     * 启动Flume度量报告
     * @param period
     * @param flumeReceiveUrl
     */
    public static void startFlumeReport(long period, String flumeReceiveUrl) {
    }

    /**
     * 启动Http度量报告
     * @param period
     */
    public static void startHttpReport(long period) {

    }

    /**
     * 启动CSV度量报告
     * @param period
     */
    public static void startCSVReport(long period) {

    }
}
