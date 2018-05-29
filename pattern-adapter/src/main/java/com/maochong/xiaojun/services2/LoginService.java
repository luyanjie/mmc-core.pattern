package com.maochong.xiaojun.services2;

import com.alibaba.fastjson.JSON;
import com.maochong.xiaojun.services2.entity.Message;
import com.maochong.xiaojun.services2.entity.MessageResponse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jokin
 * @date 2018/5/29 16:51
 */
public class LoginService {

    public static void login(String name,Object... args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> clazz = Class.forName(name);
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        Method method = clazz.getDeclaredMethod("login", parameterTypes);
        MessageResponse message = (MessageResponse) method.invoke(clazz.newInstance(), args);
        System.out.println(JSON.toJSONString(message));
    }
}
