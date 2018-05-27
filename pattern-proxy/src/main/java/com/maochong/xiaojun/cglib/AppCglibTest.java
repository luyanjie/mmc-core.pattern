package com.maochong.xiaojun.cglib;

/**
 * @auther jokin
 * @data 2018/5/27 0027 14:19
 */
public class AppCglibTest {
    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        CalculatorImpl calculator = (CalculatorImpl) proxy.getInstance(new CalculatorImpl());
        calculator.doSomething();

        calculator.doSomething();

        calculator.doSomething();

        calculator.doSomething();
    }
}
