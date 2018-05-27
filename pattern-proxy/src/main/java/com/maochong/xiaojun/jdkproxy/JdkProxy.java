package com.maochong.xiaojun.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther jokin
 * @data 2018/5/27 0027 14:28
 */
public class JdkProxy implements InvocationHandler {
    private Object targetObject;

    private int useTimes;

    public Object getInstance(Object targetObject) {
        this.targetObject = targetObject;
        Class<?> clazz = targetObject.getClass();
        // 用来生成一个新的对象（字节码重组来实现）
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(targetObject,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("调用之前做些什么呢");
    }

    private void after(){
        useTimes ++;
        System.out.println("调用之后做些什么呢");
        System.out.println(useTimes);
    }
}
