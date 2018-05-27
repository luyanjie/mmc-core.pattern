package com.maochong.xiaojun.register;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.*;
/**
 * @author jokin
 * @date 2018/5/25 10:36
 * spring 中bean 注册式 单例模式 ，类似于：com.maochong.xiaojun.unified.Singleton
 */
public class BeanFactory {
    private static Map<String,Object> bean = new ConcurrentHashMap<>();

    private BeanFactory(){}

  @SuppressWarnings("unchecked")
    public static  <T> T getBean(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        String clazzName = clazz.getName();
        if(bean.containsKey(clazzName)){
            T instance = clazz.newInstance();
            return (T)bean.put(clazzName,instance);
        }
        return (T)bean.get(clazzName);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(StringUtils.isEmpty(clazzName)){
            return null;
        }
        if(bean.containsKey(clazzName)){
            T instance = (T)Class.forName(clazzName).newInstance();
            return (T)bean.put(clazzName,instance);
            //return instance;
        }
        return (T)bean.get(clazzName);
    }
}
