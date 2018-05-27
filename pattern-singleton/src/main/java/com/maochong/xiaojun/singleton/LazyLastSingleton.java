package com.maochong.xiaojun.singleton;

/**
 * @auther jokin
 * @data 2018/5/26 0026 22:28
 * 懒汉式单例最终模式--最优化的单例模式
 * 特点：在外部类被调用的时候内部类才会被首次加载
 * 内部类一定是要在方法调用之前初始化
 * 巧妙的避免了线程安全问题。
 *
 * 这种形式兼顾了饿汉式的内存浪费的缺点，也兼顾了synchronized性能问题
 * 完美的屏蔽了这两个优点，号称史上最牛B的单例模式实现
 */
public class LazyLastSingleton {

    private static boolean initialized = false;

    /**
     * 默认使用LazyLastSingleton的时候，会先初始化内部类
     * 如果没使用的话，内部类不会被加载
     * */
    private LazyLastSingleton(){
        // 处理防止反射入侵
        synchronized (LazyLastSingleton.class){
            if(!initialized){
                initialized = !initialized;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    /**
     * 返回实例
     * 每个关键字都不是多余的
     * 1. static：是为了使单例的空间共享
     * 2. final：保证了方法不会被重写，重载
     * */
    public static final LazyLastSingleton getInstance()
    {
        // 在返回结果之前，一定会先执行LazyHolder的内部类
        return LazyHolder.LAZY;
    }

    /**
     * 内部类
     * 内部类默认不会被加载，在第一次使用的时候才会被加载
     * */
    private static class LazyHolder{
        private static final LazyLastSingleton LAZY = new LazyLastSingleton();
    }
}
