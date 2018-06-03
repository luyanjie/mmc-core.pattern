package com.maochong.xiaojun.old;

import com.maochong.xiaojun.MessageResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jokin
 * @date 2018/6/3 0003 0:44
 * 旧版本登录注册实现
 */
public class ServiceDecoratorImpl implements IServiceDecorator {
    @Override
    public MessageResponse login(String userName, String password) {
        System.out.println(StringUtils.join("旧版本登录成功...","userName:",userName,"password:",password ));
        return new MessageResponse<>(200, "login success old", StringUtils.join(userName, "====", password));
    }

    @Override
    public MessageResponse register(String userName, String password) {
        System.out.println(StringUtils.join("旧版本注册成功...","userName:",userName,"password:",password ));
        return new MessageResponse<>(200, "register success old", StringUtils.join(userName, "====", password));
    }
}
