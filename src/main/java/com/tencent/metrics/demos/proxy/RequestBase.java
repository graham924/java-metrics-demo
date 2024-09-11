package com.tencent.metrics.demos.proxy;

public class RequestBase {
    private String host;
    private int port;
    private String uri;
    private String method;
    private String body;

    public RequestBase() {
    }

    public RequestBase(String host, int port, String uri, String method, String body) {
        this.host = host;
        this.port = port;
        this.uri = uri;
        this.method = method;
        this.body = body;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
