package com.tencent.metrics.demos.metrics;


import io.micrometer.core.instrument.*;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Supplier;

public abstract class MetricBase {

    private static final String CLS_NAME_KEY = "class";

    private final MeterRegistry registry;

    public MetricBase(MeterRegistry registry) {
        this.registry = registry;
    }

    protected Metric metricName(String metricName, String baseUnit, String description, Tags tags) {
        Tags metricTags = Tags.of(tags);
        Class<?> klass = getClass();
        String clsNm = klass.getSimpleName().replaceAll("\\$$", StringUtils.EMPTY);
        metricTags = metricTags.and(CLS_NAME_KEY, clsNm);
        return Metric.of(metricName, metricTags, baseUnit, description);
    }

    public Counter newCounter(String metricName, String baseUnit, String description, Tags tags) {
        Metric mName = metricName(metricName, baseUnit, description, tags);
        return Counter.builder(mName.getMetricName()).tags(mName.getTags()).baseUnit(mName.getBaseUnit())
                .description(mName.getDescription()).register(registry);
    }
    public Gauge newGauge(String metricName, String baseUnit, String description, Tags tags, Supplier<Number> f) {
        Metric mName = metricName(metricName, baseUnit, description, tags);
        return Gauge.builder(mName.getMetricName(), f).tags(mName.getTags()).baseUnit(mName.getBaseUnit())
                .description(mName.getDescription()).register(registry);
    }

    public Timer newTimer(String metricName, String description, Tags tags) {
        Metric mName = metricName(metricName, null, description, tags);
        return Timer.builder(mName.getMetricName()).tags(mName.getTags()).description(mName.getDescription())
                .register(registry);
    }
}
