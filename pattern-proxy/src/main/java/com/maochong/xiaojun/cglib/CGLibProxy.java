package com.maochong.xiaojun.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther jokin
 * @data 2018/5/27 0027 14:17
 */
public class CGLibProxy implements MethodInterceptor {
    private int useTimes;
    private Object target;
    public Object getInstance(Object target){
        this.target=target;
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 调用之前调用
        before();
        // 调用方法
        Object result = methodProxy.invokeSuper(o,objects);
        // 调用之后调用
        after();
        return result;
    }
    private void before(){
        System.out.println("we can do something before calculate.");
    }
    private void after(){
        useTimes++;
        System.out.println("已使用："+useTimes+"次");
    }
}
