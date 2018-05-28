package com.maochong.xiaojun.payport;

import com.maochong.xiaojun.pay.PayState;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jokin
 * @date 2018/5/28 10:20
 * 支付宝支付
 */
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("========支付宝支付 处理逻辑=========");
        // 中间的处理逻辑省略了
        return new PayState<>(200, "alipay success", StringUtils.join(uid, "支付宝 支付了 ", amount));
    }
}
