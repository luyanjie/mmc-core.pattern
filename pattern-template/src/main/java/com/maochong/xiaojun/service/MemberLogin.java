package com.maochong.xiaojun.service;

import com.maochong.xiaojun.abstracts.AbstractLogin;
import com.maochong.xiaojun.entity.MessageResponse;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jokin
 * @date 2018/5/28 18:12
 * 会员玩家登陆
 */
public class MemberLogin extends AbstractLogin {
    @Override
    protected MessageResponse loginUser(String userName, String password) {
        System.out.println("");
        if(StringUtils.isEmpty(password)){
            return new MessageResponse<>(0,"登陆密码不能为空", "");
        }
        return new MessageResponse<>(200,"会员玩家登陆，验证登陆账号密码.......返回一个永久token", RandomUtils.nextLong(10000,90000));
    }
}
