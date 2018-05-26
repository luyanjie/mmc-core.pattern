package com.maochong.xiaojun.register;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jokin
 * @date 2018/5/25 11:08
 * 注册式的简单演示
 */
public class RegisterMap {
    private RegisterMap(){}

    private static Map<String,RegisterMap> register = new ConcurrentHashMap<>();

    public static RegisterMap getInstance(String name)
    {
        if(StringUtils.isEmpty(name)){
            name = RegisterMap.class.getName();
        }
        if(register.get(name) == null){
            try {
                register.put(name, new RegisterMap());
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return register.get(name);
    }
}
