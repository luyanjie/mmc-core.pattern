package com.maochong.xiaojun.services2;

/**
 * @author jokin
 * @date 2018/5/29 17:07
 */
public enum  ClassNameEnum {
    QQ("com.maochong.xiaojun.services2.LoginForQQAdapter"),
    Sina("com.maochong.xiaojun.services2.LoginForSinaAdapter"),
    Account("com.maochong.xiaojun.services2.LoginForAccountAdapter"),
    WeChat("com.maochong.xiaojun.services2.LoginForWeChatAdapter"),
    Tel("com.maochong.xiaojun.services2.LoginFotTelAdapter");

    private String className;

    ClassNameEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
