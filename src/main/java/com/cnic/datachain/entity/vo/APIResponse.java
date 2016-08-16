package com.cnic.datachain.entity.vo;

/**
 * Created by duyuanyuan on 2015/11/10.
 * good day commander!
 */
public class APIResponse {
    private boolean flag;
    private String message;
    private String apiCode;

    public APIResponse() {
    }

    public APIResponse(boolean flag, String message, String apiCode) {
        this.flag = flag;
        this.message = message;
        this.apiCode = apiCode;
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

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }
}
