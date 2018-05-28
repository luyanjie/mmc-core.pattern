package com.maochong.xiaojun.factory;

import com.maochong.xiaojun.pay.PayOrder;
import com.maochong.xiaojun.pay.PayState;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jokin
 * @date 2018/5/28 10:50
 *
 * 使用工厂模式来实现,但是这不适合使用工厂模式，工厂模式是创建一个对象，这是选择一种行为方式得使用策略模式
 */
public class AppPayFactoryTest {
    public static void main(String[] args) {

        /*System.out.println(DateUtils.getFragmentInMinutes(new Date(),Calendar.HOUR_OF_DAY));

        System.out.println(DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.format(new Date(),"yyyyMMddHHmmss"));
        System.out.println(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(new Date()));*/


        // a
        String orderId = StringUtils.join("MMC",RandomUtils.nextLong(10000L,99999L));
        System.out.println(orderId);
        PayOrder pay = new PayOrder("KB20001",orderId,12.25);
        PayState payState = pay.pay(PayFactory.getInstance().AliPay("jokin"));
        System.out.println("使用支付宝支付（接口方式）："+payState.toString());

        payState = pay.pay(PayFactory.getInstance().AliPayEnum());
        System.out.println("使用支付宝支付（枚举方式）："+payState.toString());

        payState = pay.pay(PayFactory.getInstance().WeChatPay());
        System.out.println("使用微信支付："+payState.toString());


        payState = pay.pay(PayFactory.getInstance().WeChatPayEnum());
        System.out.println("使用微信支付（枚举方式）："+payState.toString());
    }
}
