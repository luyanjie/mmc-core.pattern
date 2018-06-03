package com.maochong.xiaojun.core;

import java.lang.reflect.Method;

/**
 * @author jokin
 * @date 2018/6/3 0003 11:26
 * 事件
 */
public class Event {
    /**
     * 事件源
     * */
    private Object source;
    /**
     * 通知目标
     * */
    private Object target;
    /**
     * 回调方法
     * */
    private Method callback;
    /**
     * 触发
     * */
    private String trigger;
    /**
     * 时间
     * */
    private String time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source + ",\n" +
                "\ttarget=" + target + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttime=" + time + ",\n" +
                "\ttrigger='" + target + '\'' + "\n" +
                '}';
    }

    public String getTime() {
        return time;
    }

    Event setTime(String time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}
