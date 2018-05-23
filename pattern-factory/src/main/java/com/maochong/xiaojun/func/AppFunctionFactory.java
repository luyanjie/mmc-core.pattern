package com.maochong.xiaojun.func;

/**
 * @author jokin
 * @date 2018/5/22 11:01
 * 第二种方式：标准工厂模式
 */
public class AppFunctionFactory {
    public static void main(String[] args) {
        // 用户需要自己指定某个工厂来实现
        FunctionFactory factory = new TelunsuFactory();
        // 货比三家,,问题在于用户可能不知道不好谁好谁坏，配置也可能会配置错
        System.out.println(factory.getMilk().getName());
    }
}
