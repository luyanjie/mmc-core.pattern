package com.maochong.xiaojun.services2;

import com.maochong.xiaojun.services2.entity.MessageResponse;

/**
 * @author jokin
 * @date 2018/5/29 16:23
 * 微信 session key 登陆
 */
public class LoginForWeChatAdapter {

    public LoginForWeChatAdapter(){}

    public MessageResponse login(String session) {
        return new MessageResponse<>(200, "QQ token 登陆成功", session);
    }

}
