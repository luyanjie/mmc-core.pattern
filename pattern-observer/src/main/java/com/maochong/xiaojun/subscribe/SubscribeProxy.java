package com.maochong.xiaojun.subscribe;

import com.maochong.xiaojun.core.Event;
import com.maochong.xiaojun.core.EventListener;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jokin
 * @date 2018/6/3 0003 12:20
 * JDK动态代理
 */
public class SubscribeProxy implements InvocationHandler {

    private Object targetSource;

    private List<String> callNames = new ArrayList<>();

    /**
     * 设置需要监听的事件、参与监听类和执行方法
     *
     * @param eventType  监听事件
     * @param targets    参与监听类集合
     * @param methodName 参与监听类的执行方法名
     */
    public SubscribeProxy(String eventType, Class<?>[] targets, String methodName) throws NoSuchMethodException, IllegalAccessException, InstantiationException {

        // 添加指定监听事件（不是all）
        if (!SubscribeEventType.ON_ALL.getName().equals(eventType)) {
            // 使用单例模式添加监听事件
            for (Class<?> target : targets) {
                Method callback = target.getClass().getMethod(methodName, Event.class);
                String typeName = StringUtils.join(eventType, "_", target.getName());
                callNames.add(typeName);
                EventListener.getInstance().addListener(typeName, target.newInstance(), callback);
            }
        } else {
            // 添加所有的监听方法
            SubscribeEventType[] enums = SubscribeEventType.values();
            for (Class<?> target : targets) {
                Method callback = target.getMethod(methodName, Event.class);
                for (SubscribeEventType se : enums) {
                    if (se.getName().equals(eventType)) {
                        continue;
                    }
                    String typeName = StringUtils.join(se.getName(), "_", target.getName());
                    callNames.add(typeName);
                    EventListener.getInstance().addListener(typeName, target.newInstance(), callback);
                }
            }
        }
    }


    public SubscribeProxy(String eventType, Object targets, Method callback) throws NoSuchMethodException, IllegalAccessException, InstantiationException {

        // 添加指定监听事件（不是all）
        if (!SubscribeEventType.ON_ALL.getName().equals(eventType)) {
            // 使用单例模式添加监听事件
            String typeName = StringUtils.join(eventType, "_", targets.getClass().getName());
            callNames.add(typeName);
            EventListener.getInstance().addListener(typeName, targets, callback);
        } else {
            // 添加所有的监听方法
            SubscribeEventType[] enums = SubscribeEventType.values();
            for (SubscribeEventType se : enums) {
                if (se.getName().equals(eventType)) {
                    continue;
                }
                String typeName = StringUtils.join(se.getName(), "_", targets.getClass().getName());
                callNames.add(typeName);
                EventListener.getInstance().addListener(typeName, targets, callback);
            }
        }
    }

    /**
     * 获取代理类
     */
    public Object getInstance(Object targetSource) {
        this.targetSource = targetSource;
        return Proxy.newProxyInstance(targetSource.getClass().getClassLoader(), targetSource.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(targetSource, args);
        after(method.getName());
        return result;
    }

    /**
     * 方法执行后执行
     */
    private void after(String name) {
        for (String typeName : callNames) {
            String[] arrayNames = typeName.split("_");
            if(arrayNames[0].equals(name)){
                EventListener.getInstance().trigger(typeName);
            }
        }
    }

}
