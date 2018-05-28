package com.maochong.xiaojun.abstracts;

import com.maochong.xiaojun.commons.CryptoUtils;
import com.maochong.xiaojun.entity.MessageResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jokin
 * @date 2018/5/28 17:52
 * 以登陆为例，使用抽象类的模板模式
 * 登陆分为会员登陆，游客登陆
 */
public abstract class AbstractLogin {
    /**
     * 登陆的公共方法
     * */
    public MessageResponse login(String userName, String password){
        // 处理一些公用的方法，比如密码 用户名判断
        if(StringUtils.isEmpty(userName)){
            throw new NullPointerException("用户名不能为空！");
        }
        password = encryptPwd(password);
        // 调用登陆方法，具体子类根据自己的需要实现
        return loginUser(userName,password);
    }

    /**
     * 抽象方法，根据不同子类来实现这个具体方法
     * */
    protected abstract MessageResponse loginUser(String userName,String password);

    private String encryptPwd(String password){
        if(StringUtils.isEmpty(password)){
            return password;
        }
        try {
            return CryptoUtils.MD5.getMD5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}
