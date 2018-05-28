package com.maochong.xiaojun;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maochong.xiaojun.entity.MessageResponse;
import com.maochong.xiaojun.service.MemberLogin;
import com.maochong.xiaojun.service.NormalLogin;

/**
 * @author jokin
 * @date 2018-05-28 18:14
 * 测试会员玩家跟普通玩家登陆的效果
 */
public class AppLoginTest
{
    public static void main( String[] args )
    {
        String userName = "luyanjie";
        String password = "";

        // 普通玩家登陆.
        NormalLogin normal = new NormalLogin();
        MessageResponse message = normal.login(userName,password);
        System.out.println(JSON.toJSONString(message));
        System.out.println("=======华丽的分割线======");

        // 会员玩家登陆，需要账号密码
        MemberLogin member = new MemberLogin();
        System.out.println(JSON.toJSONString(member.login(userName,password))) ;
    }
}
