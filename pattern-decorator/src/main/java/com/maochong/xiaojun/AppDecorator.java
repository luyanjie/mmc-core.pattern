package com.maochong.xiaojun;

import com.alibaba.fastjson.JSON;
import com.maochong.xiaojun.old.ServiceDecoratorImpl;
import com.maochong.xiaojun.upgrade.IServiceUpgrade;
import com.maochong.xiaojun.upgrade.ServiceUpgradeImpl;

/**
 * 装饰器模式
 1、注重覆盖、扩展
 2、装饰器和被装饰者都实现同一个接口，主要目的是为了扩展之后依旧保留OOP关系（同宗同源）
 3、满足is-a的关系
 */
public class AppDecorator
{
    public static void main( String[] args )
    {
        IServiceUpgrade iServiceUpgrade = new ServiceUpgradeImpl(new ServiceDecoratorImpl());
        MessageResponse response = iServiceUpgrade.loginForQQ("xxxxxx");
        System.out.println(JSON.toJSONString(response));


        response = iServiceUpgrade.login("lu yan jie","123456");
        System.out.println(JSON.toJSONString(response));

        response = iServiceUpgrade.loginForTelephone("18250756961","236541");
        System.out.println(JSON.toJSONString(response));
        /*

            ===============================================================------
            装饰器模式                          |   适配器模式
            -----------------------------------+---------------------------------
            是一种非常特别的适配器模式            |  可以不保留层级关系
            -----------------------------------+---------------------------------
            装饰者和被装饰者都要实现同一个接口     |  适配者和被适配者没有必然的层级联系
            主要目的是为了扩展，依旧保留OOP关系    |  通常采用代理或者继承形式进行包装
            -----------------------------------+----------------------------------
            满足is-a的关系                      |   满足has-a
            -----------------------------------+----------------------------------
            注重的是覆盖、扩展                   |   注重兼容、转换
            -----------------------------------+----------------------------------


        */

    }
}
