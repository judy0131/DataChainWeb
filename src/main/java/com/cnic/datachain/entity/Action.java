package com.cnic.datachain.entity;

import java.util.Date;

/**
 * Created by xjzhu@cnic.cn on 2016/8/16.
 */
public class Action {

    private Integer id;
    private String logDate;
    private String logTime;
    private String logPriority;
    private String logClass;
    private Integer logLineNumber;
    private String logMethod;
    private String logMessage;

    private Date createAt;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogClass(String logClass) {
        this.logClass = logClass;
    }

    public String getLogClass() {
        return logClass;
    }

    public void setLogLineNumber(Integer logLineNumber) {
        this.logLineNumber = logLineNumber;
    }

    public Integer getLogLineNumber() {
        return logLineNumber;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogPriority(String logPriority) {
        this.logPriority = logPriority;
    }

    public String getLogPriority() {
        return logPriority;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getCreateAt() {
        return createAt;
    }
}
