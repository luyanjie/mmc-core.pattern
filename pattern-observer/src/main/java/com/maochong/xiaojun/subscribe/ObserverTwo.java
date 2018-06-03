package com.maochong.xiaojun.subscribe;

import com.maochong.xiaojun.core.Event;

/**
 * @author jokin
 * @date 2018/6/3 0003 17:30
 */
public class ObserverTwo {
    public void advice(Event e){
        System.out.println("=========触发事件，打印日志========\n observe two");
    }
}
