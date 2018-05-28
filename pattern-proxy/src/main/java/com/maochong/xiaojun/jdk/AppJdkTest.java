package com.maochong.xiaojun.jdk;

import com.maochong.xiaojun.Person;

/**
 * @author jokin
 * @date 2018/5/27 0027 13:40
 */
public class AppJdkTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDK58().getInstance(new XieMu());

            System.out.println("--buy--");
            obj.buy();
            System.out.println("--findJob--");
            obj.findJob();
            System.out.println("--findLove--");
            obj.findLove();
            System.out.println("--zufangzi--");
            obj.zufangzi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
