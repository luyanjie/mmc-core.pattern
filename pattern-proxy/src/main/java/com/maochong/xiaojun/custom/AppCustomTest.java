package com.maochong.xiaojun.custom;

/**
 * @author jokin
 * @date 2018/5/27 0027 21:44
 * 手写动态jdk代理
 */
public class AppCustomTest {
    public static void main(String[] args) {
        try {
            MCalculator calculator = (MCalculator)new JdkCustom().getInstance(new MCalculatorImpl());
            System.out.println(calculator.getClass());
            calculator.add(1,2);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
