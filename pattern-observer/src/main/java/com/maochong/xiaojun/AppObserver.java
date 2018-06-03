package com.maochong.xiaojun;

import com.maochong.xiaojun.core.Event;
import com.maochong.xiaojun.subscribe.*;

import java.lang.reflect.Method;

/**
 * 观察者模式
 * 应用场景：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变的时候，所欲依赖于它的对象得到通知并自动更新
 */
public class AppObserver
{
    public static void main( String[] args )
    {

        try {
            /*Observer observer = new Observer();
            Method method = Observer.class.getMethod("advice", new Class<?>[]{Event.class});

            SubscribeService service = new SubscribeService();
            service.addListener(SubscribeEventType.ON_ADD,observer,method);

            service.add();*/

           /*// 监听指定的方法
            ObserverOne observer = new ObserverOne();
            Method method = ObserverOne.class.getMethod("advice", new Class<?>[]{Event.class});
            ISubscribeService service = (ISubscribeService) new SubscribeProxy(SubscribeEventType.ON_ADD.getName(),observer,method)
                    .getInstance(new SubscribeService());
            service.add();*/

            // 监听所有的方法
            ISubscribeService service = (ISubscribeService) new SubscribeProxy(SubscribeEventType.ON_ALL.getName(),new Class<?>[]{ObserverOne.class,ObserverTwo.class},"advice")
                    .getInstance(new SubscribeService());
            service.add();
            service.edit();
            service.remove();
            service.query();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
