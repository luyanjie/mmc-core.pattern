package com.maochong.xiaojun.core;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jokin
 * @date 2018/6/3 0003 11:32
 * 事件Event的注册和监听
 */
public class EventListener {
    /**
     * 存放监听事件
     * */
    private final Map<String,Event> events = new HashMap<>();


    private EventListener(){}
    /**
     * 使用单例
     * */
    public static EventListener getInstance(){
        return LazyHolder.eventListener;
    }

    private static class LazyHolder{
        private final static EventListener eventListener = new EventListener();
    }

    /**
     * 注册事件
     * */
    public void addListener(String eventType, Object target, Method callback){
        if(!events.containsKey(eventType)){
            synchronized (events){
                events.put(eventType,new Event(target,callback));
            }
        }
    }

    /**
     * 触发事件
     * */
    public void trigger(String call){
        if(!events.containsKey(call)){return;}
        Event e = events.get(call).setTrigger(call.toString());
        e.setSource(this);
        e.setTime(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH-mm-ss"));

        try {
            e.getCallback().invoke(e.getTarget(),e);
        } catch (IllegalAccessException | InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }
}
