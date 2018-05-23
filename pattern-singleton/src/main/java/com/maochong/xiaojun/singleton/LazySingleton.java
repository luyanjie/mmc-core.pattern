package com.maochong.xiaojun.singleton;

/**
 * @author jokin
 * @date 2018/5/23 16:22
 * 懒汉型（双检型）
 */
public class LazySingleton {
    /**
     * 初始化为null的单例，注意volatile关键字修饰,保证线程之间的可见性
     * */
    private volatile static  LazySingleton singleton;
    /**
     * private的构造函数，为的就是不让外部直接调用该类的构造方法
     * */
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(singleton == null){
            //步骤：1
            synchronized (LazySingleton.class){
                //步骤：2
                if(singleton == null){
                    //步骤：3
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    /*
    如何理解步骤1，2，3呢
1. 线程 1 进入get 方法。
2. 由于single 为null，线程 1 在 //1 处进入 synchronized块。
3. 线程 1 被线程 2 预占。
4. 线程 2 进入get 方法。
5. 由于single 仍旧为null，线程 2 试图获取 //1 处的锁。然而，由于线程 1 持有该锁，线程 2 在 //1 处阻塞。
6. 线程 2 被线程 1 预占。
7. 线程 1 执行，由于在 //2 处实例仍旧为null，线程 1 还创建一个Singleton对象并将其引用赋值给single。
8. 线程 1 退出 synchronized块并从 get方法返回实例。
9. 线程 1 被线程 2 预占。
10. 线程 2 获取 //1 处的锁并检查single 是否为null。
11. 由于single 是非 null的，并没有创建第二个Singleton对象，由线程 1 创建的对象被返回。
    * */
}
