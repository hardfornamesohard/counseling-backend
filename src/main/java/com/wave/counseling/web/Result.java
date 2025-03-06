package com.wave.counseling.web;

/**
 * @author ziwei.huang
 * @date 2025/2/28 14:26
 */
public class Result<T> {
    public int code;
    public String message;
    public T data;

    public static Result buildSuccess(String message){
        return new Result(200, message, null);
    }
    public static Result buildSuccess(Object data){
        return new Result(200, "请求成功", data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result buildFail(String message){
        return new Result(401, message, null);
    }
    public static Result buildFail(String message, int code){
        return new Result(code, message, null);
    }
    public static Result buildFail(String message, int code, Throwable e){
        return new Result(code, message, e.getMessage());
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
