package com.maochong.xiaojun.services2;

import com.maochong.xiaojun.services2.entity.MessageResponse;

/**
 * @author jokin
 * @date 2018/5/29 16:23
 * 使用账号 密码登陆
 */
public class LoginForAccountAdapter {
    public MessageResponse login(String account,String password){
        return new MessageResponse<>(200,"账号 密码 登陆成功",new String[]{account,password});
    }
}
