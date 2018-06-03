package com.maochong.xiaojun.upgrade;

import com.maochong.xiaojun.MessageResponse;
import com.maochong.xiaojun.old.IServiceDecorator;

/**
 * @author jokin
 * @date 2018/6/3 0003 0:49
 * 新版本登录 注册，继承旧版本，然后扩展新需求接口
 */
public interface IServiceUpgrade extends IServiceDecorator {
    /**
     * QQ登录
     * */
    MessageResponse loginForQQ(String openId);

    /**
     * 微信登录
     * */
    MessageResponse loginForWechat(String openId);

    /**
     * 使用token登录
     * */
    MessageResponse loginForToken(String token);

    /**
     * 手机验证登录
     * */
    MessageResponse loginForTelephone(String telephone,String code);

    /**
     * 新版注册或登录
     * */
    MessageResponse loginForRegister(String username,String password);

}
