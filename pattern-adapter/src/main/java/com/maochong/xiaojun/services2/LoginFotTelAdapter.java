package com.maochong.xiaojun.services2;

import com.maochong.xiaojun.services2.entity.MessageResponse;

/**
 * @author jokin
 * @date 2018/5/29 16:23
 * 使用手机号 验证骂登陆
 */
public class LoginFotTelAdapter {

    public MessageResponse login(String telephone,int code) {
        return new MessageResponse<>(200, "使用手机号 验证骂登陆成功", new Object[]{telephone,code});
    }
}
