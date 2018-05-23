package com.maochong.xiaojun.singleton;

/**
 * @author jokin
 * @date 2018/5/23 16:00
 * 饿汉式
 */
public class HungrySingleton {

    private static int num = 1;
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton()
    {}

    public static HungrySingleton getInstance(){
        return singleton;
    }

    public int getNum()
    {
        return  num++;
    }
}
