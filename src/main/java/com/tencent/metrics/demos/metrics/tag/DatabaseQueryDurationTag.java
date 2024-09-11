package com.tencent.metrics.demos.metrics.tag;

public class DatabaseQueryDurationTag {
    private String database;
    private String table;
    private String operation;
    private String sql;
    private String exception;
    private String func;

    public DatabaseQueryDurationTag() {
    }

    public DatabaseQueryDurationTag(String database, String table, String operation) {
        this.database = database;
        this.table = table;
        this.operation = operation;
    }

    public DatabaseQueryDurationTag(String database, String table, String operation, String func) {
        this.database = database;
        this.table = table;
        this.operation = operation;
        this.func = func;
    }

    public DatabaseQueryDurationTag(String database, String table, String operation, String sql, String exception) {
        this.database = database;
        this.table = table;
        this.operation = operation;
        this.sql = sql;
        this.exception = exception;
    }

    public String getDatabase() {
        return database == null ? "" : database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table == null ? "" : table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getOperation() {
        return operation == null ? "" : operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSql() {
        return sql == null ? "" : sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getFunc() {
        return func == null ? "" : func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getException() {
        return exception == null ? "" : exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
