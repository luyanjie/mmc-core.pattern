package com.maochong.xiaojun.singleton;

/**
 * @author jokin
 * @date 2018/5/23 16:30
 * 静态内部类(登记式)
 */
public class StaticClassSingleton {
    private static class SingletonHolder {
        private static final StaticClassSingleton INSTANCE = new StaticClassSingleton();
    }
    private StaticClassSingleton() {
    }
    public static final StaticClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
