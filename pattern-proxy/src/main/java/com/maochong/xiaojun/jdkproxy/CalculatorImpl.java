package com.maochong.xiaojun.jdkproxy;

/**
 * @auther jokin
 * @data 2018/5/27 0027 14:27
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    @Override
    public int devide(int a, int b) {
        return a/b;
    }
}
