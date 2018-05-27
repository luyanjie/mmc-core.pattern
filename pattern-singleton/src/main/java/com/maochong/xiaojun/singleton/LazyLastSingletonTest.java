package com.maochong.xiaojun.singleton;


import java.lang.reflect.Constructor;

/**
 * @auther jokin
 * @data 2018/5/26 0026 22:47
 */
public class LazyLastSingletonTest {
    public static void main(String[] args) {
        try {
            LazyLastSingleton lazyLastSingleton = LazyLastSingleton.getInstance();
            System.out.println(lazyLastSingleton);

            System.out.println("-----华丽的分割线------");
            Class<?> clazz = LazyLastSingleton.class;
            // 通过反射拿到私有的构造函数
            Constructor c = clazz.getDeclaredConstructor();
            // 强制访问,就是强吻，不同意也要上
            c.setAccessible(true);
            // 这里会报错了，因为单例已经存在
            Object o = c.newInstance();
            System.out.println(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
