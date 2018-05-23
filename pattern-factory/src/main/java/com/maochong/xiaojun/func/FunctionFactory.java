package com.maochong.xiaojun.func;

import com.maochong.xiaojun.Milk;

/**
 * @author jokin
 * @date 2018/5/22 10:57
 * 这是第二种：标准化工厂的写法
 */
public interface FunctionFactory {
    /**
     * 工厂必然具有生成产品的能力，统一的产品输出
     * */
    Milk getMilk();
}
