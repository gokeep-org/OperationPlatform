package com.op.metric.library.metric;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/
public class MetricsConfig {
    /**
     * 报送时间间隔，单位/秒
     */
    public static final long PERIOD = 1;

    /**
     * Flume 接受url
     */
    public static final String FLUME_RECEIVE_URL = "http://localhost:41414";

    /**
     * SLF4J 日志输出配置
     */
    public static final String SLF4J_LOG_PATH = "/var/log/metric/";

    /**
     * 默认报送类型
     */
    public static final String DEFAULT_REPORT_TYPE = ReportType.CONSOLE;

    /**
     * 度量报送类型
     */
    public static final String REPORT_TYPE = DEFAULT_REPORT_TYPE;

}
