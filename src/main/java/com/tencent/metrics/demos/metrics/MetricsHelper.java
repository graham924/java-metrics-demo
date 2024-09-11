package com.tencent.metrics.demos.metrics;

import com.tencent.metrics.demos.consts.MetricsConstant;
import com.tencent.metrics.demos.metrics.tag.BusinessFailureCountTag;
import com.tencent.metrics.demos.metrics.tag.DatabaseQueryDurationTag;
import com.tencent.metrics.demos.metrics.tag.ExternalCallDurationTag;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;

public class MetricsHelper extends MetricBase {
    public MetricsHelper(MeterRegistry registry) {
        super(registry);
    }

    // metrics: database_query_duration
    public Timer buildDatabaseQueryDurationTimer(Tags tags) {
        return newTimer(MetricsConstant.DATABASE_QUERY_DURATION_NAME, MetricsConstant.DATABASE_QUERY_DURATION_DESCRIPTION, tags);
    }
    public Tags buildDatabaseQueryDurationTags(DatabaseQueryDurationTag tag) {
        return Tags.of(MetricsConstant.DATABASE_QUERY_DURATION_TAG_DATABASE, tag.getDatabase(),
                MetricsConstant.DATABASE_QUERY_DURATION_TAG_TABLE, tag.getTable(),
                MetricsConstant.DATABASE_QUERY_DURATION_TAG_OPERATION, tag.getOperation(),
                MetricsConstant.DATABASE_QUERY_DURATION_TAG_SQL, tag.getSql(),
                MetricsConstant.DATABASE_QUERY_DURATION_TAG_FUNC, tag.getFunc(),
                MetricsConstant.DATABASE_QUERY_DURATION_TAG_EXCEPTION, tag.getException());
    }

    // metrics: external_call_duration
    public Timer buildExternalCallDurationTimer(Tags tags) {
        return newTimer(MetricsConstant.EXTERNAL_CALL_DURATION_NAME, MetricsConstant.EXTERNAL_CALL_DURATION_DESCRIPTION, tags);
    }
    public Tags buildExternalCallDurationTags(ExternalCallDurationTag tag) {
        return Tags.of(MetricsConstant.EXTERNAL_CALL_DURATION_TAG_METHOD, tag.getMethod(),
                MetricsConstant.EXTERNAL_CALL_DURATION_TAG_HOST, tag.getHost(),
                MetricsConstant.EXTERNAL_CALL_DURATION_TAG_ACTION, tag.getAction(),
                MetricsConstant.EXTERNAL_CALL_DURATION_TAG_VERSION, tag.getVersion());
    }


    // metrics: business_failure_count
    public Counter buildBusinessFailureCount(Tags tags) {
        return newCounter(MetricsConstant.BUSINESS_FAILURE_COUNT_NAME, "count", MetricsConstant.BUSINESS_FAILURE_COUNT_DESCRIPTION, tags);
    }
    public Tags buildBusinessFailureCountTags(BusinessFailureCountTag tag) {
        return Tags.of(MetricsConstant.BUSINESS_FAILURE_COUNT_TAG_BUSINESS, tag.getBusiness(),
                MetricsConstant.BUSINESS_FAILURE_COUNT_TAG_SEVERITY, tag.getSeverity(),
                MetricsConstant.BUSINESS_FAILURE_COUNT_TAG_ERROR_TYPE, tag.getErrorType(),
                MetricsConstant.BUSINESS_FAILURE_COUNT_TAG_SOURCE, tag.getSource());
    }
}
