package com.maochong.xiaojun.abstracts;

/**
 * @author jokin
 * @date 2018/5/22 11:08
 * 第三种方式：抽象类工厂
 */
public class AppAbstractFactory {

    public static void main(String[] args) {
        // 对于用户而言，更加简单了
        MilkFactory factory = new MilkFactory();
        // 用户只有选择的权利了，保证了程序的健壮性。Factory里面扩展任何别的牛奶，对于用户来说没有任何的影响，只需要在使用的时候添加即可
        System.out.println("蒙牛:"+factory.getMengniu().getName());

        System.out.println("特仑苏："+factory.getTelunsu().getName());

        System.out.println("伊利："+factory.getYili().getName());
    }
}
