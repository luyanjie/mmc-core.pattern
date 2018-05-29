package com.maochong.xiaojun.services2.entity;

/**
 * @author jokin
 * @date 2018/5/29 16:29
 */
public class MessageResponse<T> {
    private int code;
    private String massage;
    private T data;

    public MessageResponse(int code, String massage, T data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
