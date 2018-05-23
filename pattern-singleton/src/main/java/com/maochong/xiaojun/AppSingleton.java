package com.maochong.xiaojun;

import com.maochong.xiaojun.singleton.LazySingleton;
import com.maochong.xiaojun.unified.ServiceAbstract;
import com.maochong.xiaojun.unified.ServiceAbstractParameter;
import com.maochong.xiaojun.unified.ServiceNum;
import com.maochong.xiaojun.unified.Singleton;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jokin
 * @date 2018/5/23 16:02
 * 单例测试
 */
public class AppSingleton {

    private static int count = 10;
    private static CountDownLatch latch = new CountDownLatch(count);

    public static void main(String[] args) {

        // hungry();
        // abstractFun();
        singleton();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void singleton()
    {
        try {
            int value = Singleton.getInstance(ServiceNum.class).add(1,2);
            System.out.println(value);
            value = Singleton.getInstance(ServiceNum.class).reduce(1,2);
            System.out.println(value);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

    }

    private static void abstractFun(){

         ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i=0;i<count;i++)
        {
            service.submit(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 使用Class实例化
                //  ServiceAbstract singleton = ServiceAbstract.getInstanceClass();
                // 使用Class name 实例化
                //  ServiceAbstract singleton = ServiceAbstract.getInstanceName();

                // 有参数的
                ServiceAbstractParameter singleton = ServiceAbstractParameter.getInstance(3);
                System.out.println("实例对象的hashcode：" + (singleton==null?0:singleton.hashCode()));
            });
        }

        service.shutdown();
        System.out.println("等待CountDownLatch.....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待了5s.....");
        for (int i=0;i<count;i++)
        {
            latch.countDown();
        }
    }


    /**
     * 饿汉试测试
     * */
    private static void hungry()
    {

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i=0;i<count;i++)
        {
            service.submit(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 饿汉型
                /*HungrySingleton singleton = HungrySingleton.getInstance();*/
                // 懒汉型
                LazySingleton singleton = LazySingleton.getInstance();
                System.out.println("实例对象的hashcode：" + singleton.hashCode());
            });
        }

        service.shutdown();
        System.out.println("等待CountDownLatch.....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待了5s.....");
        for (int i=0;i<count;i++)
        {
            latch.countDown();
        }
    }
}
