package com.maochong.xiaojun.subscribe;

import com.maochong.xiaojun.core.EventListener;

/**
 * @author jokin
 * @date 2018/6/3 0003 11:49
 * public class SubscribeService extends EventListener
 */
public class SubscribeService implements ISubscribeService {
    //通常的话，采用动态里来实现监控，避免了代码侵入
    public void add(){
        System.out.println("调用添加的方法");
        //trigger(SubscribeEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除的方法");
        //trigger(SubscribeEventType.ON_REMOVE);
    }

    public void edit(){
        System.out.println("调用编辑的方法");
        //trigger(SubscribeEventType.ON_EDIT);
    }

    public void query(){
        System.out.println("调用查询的方法");
        //trigger(SubscribeEventType.ON_QUERY);
    }
}
