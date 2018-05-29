package com.maochong.xiaojun.services2;

import com.maochong.xiaojun.services2.entity.MessageResponse;

/**
 * @author jokin
 * @date 2018/5/29 16:22
 * 使用新浪 uid 登陆
 */
public class LoginForSinaAdapter {
    public MessageResponse login(Integer uid) {
        return new MessageResponse<>(200, "新浪 uid 登陆成功", uid);
    }
}
