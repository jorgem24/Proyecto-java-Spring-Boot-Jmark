package com.example.demo.model;

import java.sql.Timestamp;


public class ActivityLog {

    private String id;
    private String ip;
    private String operationMethod;
    private String operation;
    private String user;
    private Timestamp time; // Assuming time is represented as a Unix timestamp (long)
    private String status;
    private String endpoint;
    private String domain;
    private String restMethod;

    private String version;

    // Constructors
    public ActivityLog() {
        this.version = "1.0";
        // Default constructor
    }

    public ActivityLog(String restMethod, String id, String ip, String operationMethod, String user, Timestamp time, String status, String endpoint, String domain) {
        this.id = id;
        this.ip = ip;
        this.operationMethod = operationMethod;
        this.user = user;
        this.time = time;
        this.status = status;
        this.endpoint = endpoint;
        this.domain = domain;
        this.restMethod = restMethod;
    }

    public String getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(String restMethod) {
        this.restMethod = restMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    // Getters and Setters
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperationMethod() {
        return operationMethod;
    }

    public void setOperationMethod(String operationMethod) {
        this.operationMethod = operationMethod;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "ip='" + ip + '\'' +
                ", operationMethod='" + operationMethod + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", status=" + status +
                ", version=" + version +
                ", endpoint='" + endpoint + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
