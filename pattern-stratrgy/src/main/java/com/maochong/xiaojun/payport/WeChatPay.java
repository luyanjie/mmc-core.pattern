package com.maochong.xiaojun.payport;

import com.maochong.xiaojun.pay.PayState;

/**
 * @author jokin
 * @date 2018/5/28 10:38
 * 微信支付
 */
public class WeChatPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("====微信支付====");
        return new PayState<>(404,"wechat pay fail",1000);
    }
}
