package com.maochong.xiaojun.abstracts;

import com.maochong.xiaojun.Milk;

/**
 * @author jokin
 * @date 2018/5/22 11:04
 * 第三种方式：抽象类工厂
 */
public abstract class AbstractFactory {
    // 使用抽象类而不使用接口，是因为抽象类可以实现接口的功能，并且一些公用逻辑可以直接写在抽象类中，便于管理

    String print()
    {
        System.out.println("统一，公用方法");
        return "hello";
    }

    /**
     * 获取一个蒙牛品牌的牛奶
     * */
    public abstract Milk getMengniu();

    /**
     * 获取一个伊利品牌的牛奶
     * */
    public abstract Milk getYili();

    /**
     * 获取一个特仑苏品牌的牛奶
     * */
    public abstract Milk getTelunsu();
}
