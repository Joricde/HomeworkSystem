package com.homeworksystem.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServerResult<T> implements Serializable {
    private T data;
    private boolean success;
    private int code;
    private String message;

    private ServerResult() {}


    private ServerResult(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private ServerResult(T data, boolean success, int code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 返回失败，code码和msg自定义
     */
    public static <T> ServerResult<T> newInstance(){
        return new ServerResult<T>();
    }


    /**
     * 调用默认成功
     */
    public static <T> ServerResult<T> defaultSuccess(T data){
        return new ServerResult<T>(data, true, 200, "返回成功");
    }

    /**
     * 返回默认失败
     */
    public static <T> ServerResult<T> defaultFailure(){
        return new ServerResult<T>(false, 500, "系统内部错误");
    }

    /**
     * 自定义失败一
     */
    public static <T> ServerResult<T> failure(T data, int code, String message){
        return new ServerResult<T>(data, false, code, message);
    }

    /**
     * 自定义失败二
     */
    public static <T> ServerResult<T> failure(int code, String message){
        return new ServerResult<T>(false, code, message);
    }


}
