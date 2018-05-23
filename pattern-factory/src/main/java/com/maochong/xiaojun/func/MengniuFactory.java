package com.maochong.xiaojun.func;

import com.maochong.xiaojun.Mengniu;
import com.maochong.xiaojun.Milk;

/**
 * @author jokin
 * @date 2018/5/22 10:59
 */
public class MengniuFactory implements FunctionFactory {
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
