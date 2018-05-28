package com.maochong.xiaojun.factory;

import com.maochong.xiaojun.pay.PayState;
import com.maochong.xiaojun.payport.AliPay;
import com.maochong.xiaojun.payport.PayTypeEnum;
import com.maochong.xiaojun.payport.Payment;
import com.maochong.xiaojun.payport.WeChatPay;

/**
 * @author jokin
 * @date 2018/5/28 10:47
 * 单例结合工厂模式使用
 * 这个单例使用了创建内部类的方式，结合了懒汉和饿汉的优点
 */
public class PayFactory extends AbstractFactory {

    /**
     * 判断是否允许创建对象
     * 主要是为了防止反射在创建对象，这里是单例模式
     */
    private static boolean initialized = false;

    private PayFactory() {
        synchronized (PayFactory.class) {
            if (!initialized) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    public static PayFactory getInstance() {
        return PayHolder.LAZY;
    }

    private static class PayHolder {
        private static final PayFactory LAZY = new PayFactory();
    }


    @Override
    public Payment AliPay(String name) {
        System.out.println(name);
        return new AliPay();
    }

    @Override
    public Payment WeChatPay() {
        return new WeChatPay();
    }

    @Override
    public PayTypeEnum AliPayEnum() {
        return PayTypeEnum.ALI_PAY;
    }

    @Override
    public PayTypeEnum WeChatPayEnum() {
        return PayTypeEnum.WECHAT_PAY;
    }
}
