package com.maochong.xiaojun.custom;

import java.lang.reflect.Method;

/**
 * @author jokin
 * @date 2018/5/27 0027 21:46
 */
public class JdkCustom implements MInvocationHandler {

    private Object targetObject;

    public Object getInstance(Object targetObject){
        this.targetObject = targetObject;
        Class<?> clazz = targetObject.getClass();
        return MProxy.newProxyInstance(new MClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(targetObject,args);
    }
}
