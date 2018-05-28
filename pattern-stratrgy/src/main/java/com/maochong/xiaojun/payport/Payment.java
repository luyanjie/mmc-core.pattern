package com.maochong.xiaojun.payport;

import com.maochong.xiaojun.pay.PayState;

/**
 * @author jokin
 * @date 2018/5/28 10:20
 * 支付渠道接口
 */
public interface Payment {
    PayState pay(String uid,double amount);
}
