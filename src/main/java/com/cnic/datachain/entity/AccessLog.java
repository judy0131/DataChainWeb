package com.cnic.datachain.entity;

/**
 * Created by Flora on 2016/8/23.
 */
public class AccessLog {
    private String ip;
    private String user;
    private String timestamp;
    private String request;
    private String status;
    private int length;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getRequest() {
        return request;
    }

    public String getStatus() {
        return status;
    }

    public int getLength() {
        return length;
    }
}
