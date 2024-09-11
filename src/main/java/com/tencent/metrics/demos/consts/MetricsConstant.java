package com.tencent.metrics.demos.consts;

public class MetricsConstant {
    // metrics: database_query_duration
    public static final String DATABASE_QUERY_DURATION_NAME = "database.query.duration";
    public static final String DATABASE_QUERY_DURATION_DESCRIPTION = "database query duration";
    public static final String DATABASE_QUERY_DURATION_TAG_DATABASE = "database";
    public static final String DATABASE_QUERY_DURATION_TAG_TABLE = "table";
    public static final String DATABASE_QUERY_DURATION_TAG_OPERATION = "operation";
    public static final String DATABASE_QUERY_DURATION_TAG_SQL = "sql";
    public static final String DATABASE_QUERY_DURATION_TAG_EXCEPTION = "exception";
    public static final String DATABASE_QUERY_DURATION_TAG_FUNC = "func";


    // metrics: external_call_duration
    public static final String EXTERNAL_CALL_DURATION_NAME = "external.call.duration";
    public static final String EXTERNAL_CALL_DURATION_DESCRIPTION = "external call duration";
    public static final String EXTERNAL_CALL_DURATION_TAG_METHOD = "method";
    public static final String EXTERNAL_CALL_DURATION_TAG_HOST = "host";
    public static final String EXTERNAL_CALL_DURATION_TAG_ACTION = "action";
    public static final String EXTERNAL_CALL_DURATION_TAG_VERSION = "version";
    public static final String EXTERNAL_CALL_DURATION_TAG_EXCEPTION = "exception";


    // metrics: business_failure_count
    public static final String BUSINESS_FAILURE_COUNT_NAME = "business.failure.count";
    public static final String BUSINESS_FAILURE_COUNT_DESCRIPTION = "critical business failure count";
    public static final String BUSINESS_FAILURE_COUNT_TAG_BUSINESS = "business";
    public static final String BUSINESS_FAILURE_COUNT_TAG_SEVERITY = "severity";
    public static final String BUSINESS_FAILURE_COUNT_TAG_ERROR_TYPE = "error_type";
    public static final String BUSINESS_FAILURE_COUNT_TAG_SOURCE = "source";
}
