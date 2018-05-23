package com.maochong.xiaojun.unified;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jokin
 * @date 2018/5/23 17:25
 * 统一的单例模式
 */
public class Singleton {

    private static Map<String,Object> singletonMap = new HashMap<>();

    /**
     * 构造函数有参数单例
     * @param clazz 要实例化的类
     * @param parameterTypes 构造函数内的参数类型集合
     * @param args 构造函数内的参数对应的传入值
     * @return 实例化对象
     * */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(final Class<T> clazz,Class<?>[] parameterTypes,Object[] args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String clazzName = clazz.getName();

        if(!singletonMap.containsKey(clazzName)){
            synchronized (singletonMap){
                if(!singletonMap.containsKey(clazzName)){
                    // 完成构造函数
                    Constructor<T> constructor = clazz.getConstructor(parameterTypes);
                    // 传入参数返回实例
                    T instance = constructor.newInstance(args);
                    singletonMap.put(clazzName,instance);
                    return instance;
                }
            }
        }
        return (T)singletonMap.get(clazzName);
    }

    /**
     * 单例
     * @param classzz 要实例化的类
     * @return 实例化对象
     * */
    public static <T> T getInstance(final Class<T> classzz) throws IllegalAccessException, InstantiationException {
        String clazzName = classzz.getName();
        if(!singletonMap.containsKey(clazzName)){
            synchronized (singletonMap){
                if(!singletonMap.containsKey(clazzName)){
                    T instance = classzz.newInstance();
                    singletonMap.put(clazzName,instance);
                    return instance;
                }
            }
        }
        return (T)singletonMap.get(clazzName);
    }
}
