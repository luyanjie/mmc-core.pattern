package com.maochong.xiaojun.unified;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jokin
 * @date 2018/5/23 16:30
 * 使用继承抽象类实现统一单例
 */
public abstract class AbstractSingleton {
    /**
     * 实例存入到HashMap中
     * */
    private static final Map<String,AbstractSingleton> registryMap = new HashMap<>();

    /**
     * 构造函数创建实例只能new 不然报错
     * */
    protected AbstractSingleton() throws SingletonException{
        // 获取子类的名称
        String name = this.getClass().getName();
        if(registryMap.containsKey(name)){
            throw  new SingletonException("Cannot construct instance for class " + name + ", since an instance already exists!");
        }
        else {
            synchronized (registryMap) {
                if (!registryMap.containsKey(name)) {
                    registryMap.put(name, this);
                } else {
                    throw new SingletonException("Cannot construct instance for class " + name + ", since an instance already exists!");
                }
            }
        }
    }

    /**
     * 传入class只实例化一次
     * */
    @SuppressWarnings("unchecked")
    public static <T extends AbstractSingleton> T getInstance(final Class<T> clazz) throws InstantiationException, IllegalAccessException{
        String name = clazz.getName();
        if(!registryMap.containsKey(name)){
            synchronized (registryMap){
                if(!registryMap.containsKey(name)){
                    T instance = clazz.newInstance();
                    registryMap.put(name,instance);
                    return instance;
                }
            }
        }
        return (T)registryMap.get(name);
    }

    /**
     * 传入class name 获取class 实例化写入map 返回实例
     *  */
    public static AbstractSingleton getInstance(final String clazzName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(!registryMap.containsKey(clazzName)){
            Class<? extends AbstractSingleton> clazz = Class.forName(clazzName).asSubclass(AbstractSingleton.class);
            synchronized (registryMap){
                if(!registryMap.containsKey(clazzName)){
                    AbstractSingleton instance = clazz.newInstance();
                    registryMap.put(clazzName,instance);
                    return instance;
                }
            }
        }
        return registryMap.get(clazzName);
    }

    /**
     * 传入class只实例化一次
     * @param clazz 传入的子类
     * @param parameterTypes 参数类型 new Class[]{int.class,String.class}
     * @param args 对应 parameterTypes参数类型的参数值 new Object[]{1,"string kk"}
     * */
    @SuppressWarnings("unchecked")
    public static <T extends AbstractSingleton> T getInstanceParameter(Class<T> clazz,Class<?>[] parameterTypes,Object[] args)
            throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException, InstantiationException, IllegalAccessException{
        String clazzName = clazz.getName();
        if(!registryMap.containsKey(clazzName)){
            synchronized(registryMap){
                if(!registryMap.containsKey(clazzName)){
                    Constructor<T> constructor = clazz.getConstructor(parameterTypes);
                    T instance = constructor.newInstance(args);
                    registryMap.put(clazzName,instance);
                    return instance;
                }
            }
        }
        return (T) registryMap.get(clazzName);
    }

    /**
     * 自定义singleton异常
     * */
    protected static class SingletonException extends Exception {
        private static final long serialVersionUID = -8633183690442262445L;
        private SingletonException(String message){
            super(message);
        }
    }
}
