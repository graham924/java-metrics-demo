package com.tencent.metrics.demos.metrics.tag;

public class BusinessFailureCountTag {
    private String business;
    private String severity;
    private String errorType;
    private String source;

    public BusinessFailureCountTag() {
    }

    public BusinessFailureCountTag(String business, String severity, String errorType, String source) {
        this.business = business;
        this.severity = severity;
        this.errorType = errorType;
        this.source = source;
    }

    public String getBusiness() {
        return business == null ? "" : business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getSeverity() {
        return severity == null ? "" : severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getErrorType() {
        return errorType == null ? "" : errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getSource() {
        return source == null ? "" : source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
