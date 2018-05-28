package com.maochong.xiaojun.factory;

import com.maochong.xiaojun.pay.PayState;
import com.maochong.xiaojun.payport.PayTypeEnum;
import com.maochong.xiaojun.payport.Payment;

/**
 * @author jokin
 * @date 2018/5/28 10:44
 * 如果使用抽象工厂模式来实现呢
 */
public abstract class AbstractFactory {

    // 抽象类 可以设置公用方法，写一些公用的内容，比如参数判断什么呢

    /**
     * 支付宝支付(使用接口)
     * */
    public abstract Payment AliPay(String name);

    /**
     * 微信支付（使用接口）
     * */
    public abstract Payment WeChatPay();

    /**
     * 使用枚举方式
     * */
    public abstract PayTypeEnum AliPayEnum();

    /**
     * 使用枚举方式
     * */
    public abstract PayTypeEnum WeChatPayEnum();
}
