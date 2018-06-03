package com.maochong.xiaojun;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/6/3 0003 0:55
 */

public class MessageResponse<T> implements Serializable {
    /**
     * 序列化 反序列化的实体类的唯一标记
     * */
    private static final long serialVersionUID = 6330200039658198047L;

    private int code;

    private String message;

    private T data;

    public MessageResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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
}
