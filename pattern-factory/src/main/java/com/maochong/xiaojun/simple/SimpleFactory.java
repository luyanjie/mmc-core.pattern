package com.maochong.xiaojun.simple;

import com.maochong.xiaojun.Mengniu;
import com.maochong.xiaojun.Milk;
import com.maochong.xiaojun.Telunsu;
import com.maochong.xiaojun.Yili;

/**
 * @author jokin
 * @date 2018/5/22 10:51
 * 第一种方式：简单型的工厂模式
 */
public class SimpleFactory {
    public Milk getMaik(String name)
    {
        switch (name)
        {
            case "特仑苏":
                return  new Telunsu();
            case "伊利":
                return new Yili();
            case "蒙牛":
                return new Mengniu();
            default:
                System.out.println("没有你要找的类型");
                return null;
        }
    }
}
