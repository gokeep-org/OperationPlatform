package com.op.metric.library.metric;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/
public class MetricsConfig {

    public static final long PERIOD = Integer.parseInt(PropertiesUtil.getValue("metrics.period"));
    
    public static final String FLUME_RECEIVE_URL = PropertiesUtil.getValue("metrics.flume.receive.url");
    
    public static final String SLF4J_LOG_PATH = PropertiesUtil.getValue("metrics.slf4j.log.path");
    
    public static final String DEFAULT_REPORT_TYPE = ReportType.CONSOLE;
    
    public static final String REPORT_TYPE = PropertiesUtil.getValue("metrics.report.type");
    
    public static final String INFLUXDB_HOST = "http://localhost";
    
    public static final int INFLUXDB_PORT = 8086;
    
    public static final String INFLUXDB_DB_NAME = "test";
    
    public static final String INFLUXDB_USERNAME = "root";
    
    public static final String INFLUXDB_PASSWORD = null;
}
