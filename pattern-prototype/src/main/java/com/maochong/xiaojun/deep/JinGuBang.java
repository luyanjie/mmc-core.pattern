package com.maochong.xiaojun.deep;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/5/24 10:28
 * 金箍棒
 */
public class JinGuBang implements Serializable {

    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /= 2;
        this.h /= 2;
    }
}
