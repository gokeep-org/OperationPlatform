package com.op.metric.library.metric;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;


/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/22.
 ****************************************/
public class MetricsRegistryImpl implements MetricsRegistry {

    private static final MetricRegistry metricRegistry = MetricsRegistryBuilder.getMetricRegistry();
    private static ConcurrentMap<String, Queue> queues = new ConcurrentHashMap<String, Queue>();

    @Override
    public <T extends Metric> T registry(String name, T metric) {
        return metricRegistry.register(name, metric);
    }

    @Override
    public Meter meter(String name) {
       return metricRegistry.meter(name);
    }

    @Override
    public Counter counter(String counter) {
        return metricRegistry.counter(counter);
    }

    @Override
    public Gauge gauger(String name) {
        Queue queue = new LinkedBlockingDeque();
        queues.put(name, queue);
        return metricRegistry.register(name,
                new Gauge<Integer>() {
                    @Override
                    public Integer getValue() {
                        return queue.size();
                    }
                });
    }

    @Override
    public Histogram histogram(String name) {
        return metricRegistry.histogram(name);
    }

    @Override
    public Timer timer(String name) {
        return metricRegistry.timer(name);
    }

    @Override
    public boolean remove(String name) {
        return metricRegistry.remove(name);
    }
}
