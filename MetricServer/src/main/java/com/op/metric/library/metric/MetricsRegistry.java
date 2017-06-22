package com.op.metric.library.metric;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.Timer;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/
public interface MetricsRegistry {

    public <T extends Metric> T registry(String name, T metric);
    /**
     * meter平均速率注册
     * @param name
     */
    public Meter meter(String name);

    /**
     * counter计数器注册
     * @param counter
     */
    public Counter counter(String counter);

    /**
     * geuger瞬时值注册
     * @param name
     */
    public Gauge gauger(String name);

    /**
     * histogram直方图注册
     * @param name
     */
    public Histogram histogram(String name);

    /**
     * timer计时器注册
     * @param name
     */
    public Timer timer(String name);

    /**
     * 移除已经注册的度量
     * @param name
     */
    public boolean remove(String name);
}
