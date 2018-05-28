package com.maochong.xiaojun.pay;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/5/28 10:16
 * 支付状态返回
 */
public class PayState<T> implements Serializable {
    /**
     * 支付状态
     * */
    public int code;

    /**
     * 状态信息
     * */
    public String message;

    public T data;

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

    public PayState(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
