package com.maochong.xiaojun.custom;

import java.lang.reflect.Method;

/**
 * @auther jokin
 * @data 2018/5/27 0027 20:56
 */
public interface MInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
