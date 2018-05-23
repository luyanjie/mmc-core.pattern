package com.maochong.xiaojun.func;

import com.maochong.xiaojun.Milk;
import com.maochong.xiaojun.Yili;

/**
 * @author jokin
 * @date 2018/5/22 11:00
 */
public class YiliFactory implements FunctionFactory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
