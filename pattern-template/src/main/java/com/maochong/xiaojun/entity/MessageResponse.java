package com.maochong.xiaojun.entity;

/**
 * @author jokin
 * @date 2018/5/28 18:19
 */
public class MessageResponse<T> {
    private int code;
    private String Message;
    private T date;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public MessageResponse(int code, String message, T date) {
        this.code = code;
        Message = message;
        this.date = date;
    }
}
