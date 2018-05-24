package com.maochong.xiaojun.simple;

/**
 * @author jokin
 * @date 2018/5/24 10:12
 * 原型模式的简单方式
 */
public class AppClone {
    public static void main(String[] args) {
        CloneTarget p = new CloneTarget();
        p.name = "Jokin";
        p.num = 1;
        p.target = new CloneTarget();
        p.target.name = "nihao";
        System.out.println(p.target);
        System.out.println(p.target.name);
        System.out.println("---------华丽的分割线--------");
        CloneTarget obj = null;
        try {
            // 进行复制克隆
            obj = (CloneTarget) p.clone();
            System.out.println(obj.target);
            obj.name = "mao";
            obj.target.name = "kk";
            p.num = 2;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return;
        }
        System.out.println("---------华丽的分割线--------");
        System.out.println("p.name:"+p.name);
        System.out.println("obj.name:"+obj.name);

        System.out.println("p.num:"+p.num);
        System.out.println("obj.num:"+obj.num);

        System.out.println("p.target.name:"+p.target.name);
        System.out.println("obj.target.name:"+obj.target.name);
    }
}
