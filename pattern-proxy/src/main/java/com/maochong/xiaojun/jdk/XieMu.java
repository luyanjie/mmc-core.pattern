package com.maochong.xiaojun.jdk;

import com.maochong.xiaojun.Person;

/**
 * @auther jokin
 * @data 2018/5/27 0027 13:33
 * 媒婆代找对象
 */
public class XieMu implements Person {
    @Override
    public void findLove() {
        println("高富帅");
        println("身高180cm");
        println("胸大，6块腹肌");
    }

    @Override
    public void zufangzi() {
        println("租房子");
    }

    @Override
    public void buy() {
        println("买东西");
    }

    @Override
    public void findJob() {
        println("月薪20K-50k");
        println("找工作");
    }

    private void println(String message){
        System.out.println(message);
    }

}
