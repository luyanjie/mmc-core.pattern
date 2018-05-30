package com.maochong.xiaojun.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jokin
 * @date 2018/5/30 13:58
 * 静态类反射处理
 */
public class AppStaticReflexTest {
    public static void main(String[] args) {
        try {
            // 创建类
            Class<?> clazz = Class.forName("com.maochong.xiaojun.reflex.StaticUtils");
            //获取nameField 属性
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            //输出值
            System.out.println(nameField.get(nameField));

            // 没有返回值 没有参数
            System.out.println("======没有返回值 没有参数=====");
            Method getTipMethod1 = clazz.getMethod("getTips");
            getTipMethod1.invoke(null);

            // 有返回值 没有参数
            System.out.println("======有返回值 没有参数======");
            Method getTipMethod2 = clazz.getMethod("getTip");
            String result2 = (String) getTipMethod2.invoke(null);
            System.out.println("getTip返回值："+result2);

            // 没有返回值，有参数
            System.out.println("=======没有返回值，有参数=======");
            Method getTipMethod3 = clazz.getMethod("getTip",String.class);
            getTipMethod3.invoke(null,"can shu");

            // 有返回值，有参数
            System.out.println("=======有返回值，有参数=======");
            Method getTipMethod4 = clazz.getMethod("getTip",int.class);
            String result4 = (String)getTipMethod4.invoke(null,233343);
            System.out.println("getTipMethod4 返回值："+ result4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
