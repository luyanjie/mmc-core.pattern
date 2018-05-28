package com.maochong.xiaojun.payport;

/**
 * @author jokin
 * @date 2018/5/28 10:27
 * 枚举支付类型
 */
public enum PayTypeEnum {
    /**
     * 支付宝支付
     * */
    ALI_PAY(new AliPay()),
    /**
     * 微信支付
     * */
    WECHAT_PAY(new WeChatPay());

    private Payment payment;

    PayTypeEnum(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
