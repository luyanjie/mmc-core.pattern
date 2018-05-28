package com.maochong.xiaojun.service;

import com.maochong.xiaojun.abstracts.AbstractLogin;
import com.maochong.xiaojun.entity.MessageResponse;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author jokin
 * @date 2018/5/28 18:11
 * 普通玩家登陆
 */
public class NormalLogin extends AbstractLogin {
    @Override
    protected MessageResponse loginUser(String userName, String password) {
       return new MessageResponse<>(200,"普通玩家登陆，不需要验证登陆密码...返回一个零时token", RandomUtils.nextLong(10000,90000));
    }
}
