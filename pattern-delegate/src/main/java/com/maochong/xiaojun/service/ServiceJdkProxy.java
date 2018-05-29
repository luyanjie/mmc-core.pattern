package com.maochong.xiaojun.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jokin
 * @date 2018/5/29 11:26
 * 在使用一个动态代理模式选择使用
 */
public class ServiceJdkProxy implements InvocationHandler {

    private Object targetObject;

    public Object getInstance(Object targetObject){
        this.targetObject = targetObject;
        Class<?> clazz = targetObject.getClass();
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
        System.out.println("代理执行前做一些事情.....");
    }

    private void after(){
        System.out.println("代理执行后做一些事情.....");
    }
}
