package com.maochong.xiaojun.services2;

/**
 * @author jokin
 * @date 2018-05-29 16:20
 * 已各种登陆为例
 * <p>
 * 适配器模式 简单来说就是，几个完全没有关联的接口实现，放在一个地方统一实现
 */
public class AppService2Test {
    public static void main(String[] args) {
        try {
            LoginService.login(ClassNameEnum.QQ.getClassName(), "SSSS");
            LoginService.login(ClassNameEnum.WeChat.getClassName(), "ccccc");
            LoginService.login(ClassNameEnum.Sina.getClassName(), 2222);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
