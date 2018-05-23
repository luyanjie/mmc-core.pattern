package com.maochong.xiaojun.abstracts;

import com.maochong.xiaojun.Mengniu;
import com.maochong.xiaojun.Milk;
import com.maochong.xiaojun.Telunsu;
import com.maochong.xiaojun.Yili;

/**
 * @author jokin
 * @date 2018/5/22 11:07
 */
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        System.out.println(print());
        return new Mengniu();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }
}
