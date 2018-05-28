package com.maochong.xiaojun.pay;

import com.maochong.xiaojun.payport.PayTypeEnum;
import com.maochong.xiaojun.payport.Payment;

/**
 * @author jokin
 * @date 2018/5/28 10:29
 */
public class PayOrder {

    private String uid;
    private String orderId;
    private double amount;

    public PayOrder(String uid,String orderId,double amount){
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    /**
     * 这个参数可以直接使用Payment接口代替
     *
     * 使用接口或者枚举完美解决了switch的过程，不允许在代码逻辑中写switch了，当然也不必要在写if  else if，增加支付类型的时候 只需要在枚举PayTypeEnum中添加对应的即可
     * */
    public PayState pay(PayTypeEnum payTypeEnum){
        return payTypeEnum.getPayment().pay(uid,amount);
    }

    /**
     * 使用接口
     * */
    public PayState pay(Payment payment){
        return payment.pay(uid,amount);
    }
}
