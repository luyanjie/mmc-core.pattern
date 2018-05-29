package com.maochong.xiaojun.services2;

import com.maochong.xiaojun.services2.entity.Message;
import com.maochong.xiaojun.services2.entity.MessageResponse;

/**
 * @author jokin
 * @date 2018/5/29 16:22
 * 使用QQ token登陆
 */
public class LoginForQQAdapter {

    public LoginForQQAdapter(){}

    public MessageResponse login(String token) {
        return new MessageResponse<>(200, "QQ token 登陆成功", new String[]{token});
    }
}
