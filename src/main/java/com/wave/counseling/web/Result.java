package com.wave.counseling.web;

/**
 * @author ziwei.huang
 * @date 2025/2/28 14:26
 */
public class Result {
    public int code;
    public String message;
    public Object data;

    public static Result buildSuccess(String message){
        return new Result(200, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
