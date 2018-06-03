package com.maochong.xiaojun.old;

import com.maochong.xiaojun.MessageResponse;

/**
 * @author jokin
 * @date 2018/6/3 0003 0:40
 * 旧版本登录注册接口
 */
public interface IServiceDecorator {
    /**
     * 登录
     * */
    MessageResponse login(String userName, String password);
    /**
     * 注册
     * */
    MessageResponse register(String userName,String password);
}
