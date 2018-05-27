package com.maochong.xiaojun.custom;

/**
 * @auther jokin
 * @data 2018/5/27 0027 21:04
 */
public class MCalculatorImpl implements MCalculator {
    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }

    @Override
    public void subtract(int a, int b) {
        System.out.println(a-b);
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println(a*b);
    }

    @Override
    public void devide(int a, int b) {
        System.out.println(a/b);
    }
}
