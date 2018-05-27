package com.maochong.xiaojun.custom;

/**
 * @auther jokin
 * @data 2018/5/27 0027 21:44
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
