package com.maochong.xiaojun.simple;

/**
 * @author jokin
 * @date 2018/5/22 10:54
 * 第一种方式：最简单粗暴的工厂模式，但是也已经不需要用户直接new 一个实际使用对象了
 */
public class AppSimpleFactory {
    public static void main(String[] args) {
        // new 一个简单的工厂来实现
        SimpleFactory factory = new SimpleFactory();
        // 使用名字来获取
        System.out.println(factory.getMaik("蒙牛"));
    }
}
