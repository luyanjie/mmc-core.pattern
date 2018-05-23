package com.maochong.xiaojun.func;

import com.maochong.xiaojun.Milk;
import com.maochong.xiaojun.Telunsu;

/**
 * @author jokin
 * @date 2018/5/22 10:59
 */
public class TelunsuFactory implements FunctionFactory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
