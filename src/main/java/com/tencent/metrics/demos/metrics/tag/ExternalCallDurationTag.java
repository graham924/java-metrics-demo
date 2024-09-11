package com.tencent.metrics.demos.metrics.tag;

public class ExternalCallDurationTag {
    private String method;
    private String host;
    private String action;
    private String version;
    private String outcome;
    private String status;
    private String exception;


    public ExternalCallDurationTag(String method, String host, String action, String version, String outcome, String status, String exception) {
        this.method = method;
        this.host = host;
        this.action = action;
        this.version = version;
        this.outcome = outcome;
        this.status = status;
        this.exception = exception;
    }

    public ExternalCallDurationTag(String method, String host, String action, String version) {
        this.method = method;
        this.host = host;
        this.action = action;
        this.version = version;
    }

    public ExternalCallDurationTag() {
    }

    public String getMethod() {
        return method == null ? "" : method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHost() {
        return host == null ? "" : host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAction() {
        return action == null ? "" : action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getVersion() {
        return version == null ? "" : version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOutcome() {
        return outcome == null ? "" : outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getException() {
        return exception == null ? "" : exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
