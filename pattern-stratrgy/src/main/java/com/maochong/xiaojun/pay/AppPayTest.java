package com.maochong.xiaojun.pay;

import com.maochong.xiaojun.payport.PayTypeEnum;

/**
 * @author jokin
 * @date  2018-05-28 10:36
 * 策略模式
 */
public class AppPayTest
{
    public static void main( String[] args )
    {
        PayOrder pay = new PayOrder("KB20001","MMC201805280010001",12.25);
        PayState  payState = pay.pay(PayTypeEnum.ALI_PAY);

        System.out.println(payState);
    }
}
