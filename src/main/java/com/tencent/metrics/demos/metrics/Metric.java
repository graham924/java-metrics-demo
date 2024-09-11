package com.tencent.metrics.demos.metrics;

import io.micrometer.core.instrument.Tags;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class Metric {

    private final Tags tags;
    private final String metricName;
    private final String description;
    private final String baseUnit;

    public Metric(String metricName, Tags tags, String baseUnit, String description) {
        this.metricName = metricName;
        this.tags = tags;
        this.baseUnit = baseUnit;
        this.description = description;
    }

    public static Metric of(String metricName, Tags tags) {
        return new Metric(metricName, tags, StringUtils.EMPTY, StringUtils.EMPTY);
    }

    public static Metric of(String metricName, Tags tags, String baseUnit, String description) {
        return new Metric(metricName, tags, StringUtils.trimToEmpty(baseUnit),
                StringUtils.trimToEmpty(description));
    }

    public Tags getTags() {
        return tags;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getDescription() {
        return description;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Metric that = (Metric) o;

        return new EqualsBuilder().append(tags, that.tags).append(metricName, that.metricName)
                .append(baseUnit, that.baseUnit).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(tags).append(metricName).append(baseUnit).toHashCode();
    }
}
