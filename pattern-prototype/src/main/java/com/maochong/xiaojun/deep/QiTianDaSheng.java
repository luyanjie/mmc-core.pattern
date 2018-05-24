package com.maochong.xiaojun.deep;

import java.io.*;
import java.util.Date;

/**
 * @author jokin
 * @date 2018/5/24 10:29
 * 齐天大圣
 */
public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {
    /**
     * 金箍棒
     * */
    public JinGuBang jinGuBang;

    public QiTianDaSheng(){
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    /**
     * 克隆
     * */
    public QiTianDaSheng copy(QiTianDaSheng target){

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.height;

        qiTianDaSheng.jinGuBang = new JinGuBang();
        qiTianDaSheng.jinGuBang.h = target.jinGuBang.h;
        qiTianDaSheng.jinGuBang.d = target.jinGuBang.d;

        qiTianDaSheng.birthday = new Date();
        return  qiTianDaSheng;
    }

    /**
     * 深度克隆
     * */
    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos =new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaSheng copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();
            return copy;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


}
