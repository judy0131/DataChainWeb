package com.cnic.datachain.entity;
/**
 * Created by pangbo on 2014/10/24.
 * good day commander!
 */
public class RequestResult {
    private boolean flag;
    private String message;
    private String receiveDate;
    private String requestResource;
    private String responseClass;
    private Object result;

    public RequestResult(boolean flag, String message, Object result) {
        this.flag = flag;
        this.message = message;
        this.result = result;
    }

    public RequestResult(boolean flag, String message, String receiveDate, String requestResource, String responseClass, Object result) {
        this.flag = flag;
        this.message = message;
        this.receiveDate = receiveDate;
        this.requestResource = requestResource;
        this.responseClass = responseClass;
        this.result = result;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getRequestResource() {
        return requestResource;
    }

    public void setRequestResource(String requestResource) {
        this.requestResource = requestResource;
    }

    public String getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(String responseClass) {
        this.responseClass = responseClass;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestResult(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public RequestResult(boolean flag) {
        this.flag = flag;
    }
}
