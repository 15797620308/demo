package com.example.model;

public class jsondata {
    int code;
    content content;
    String message;
    boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public com.example.model.content getContent() {
        return content;
    }

    public void setContent(com.example.model.content content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
