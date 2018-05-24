package com.maochong.xiaojun.deep;

/**
 * @author jokin
 * @date 2018/5/24 10:35
 */
public class AppDeepClone {
    public static void main(String[] args) {

        QiTianDaSheng  qiTianDaSheng = new QiTianDaSheng();
        System.out.println("hashcode");
        System.out.println(qiTianDaSheng.jinGuBang.hashCode());

        try {
            QiTianDaSheng clone = (QiTianDaSheng)qiTianDaSheng.clone();
            System.out.println(clone.jinGuBang.hashCode());
            System.out.println(qiTianDaSheng.jinGuBang == clone.jinGuBang);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("-----------华丽的分割线---------------");

        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng c = q.copy(q);

        System.out.println(q.jinGuBang == c.jinGuBang);
        System.out.println("hashcode");
        System.out.println(q.jinGuBang.hashCode());
        System.out.println(c.jinGuBang.hashCode());
        System.out.println("-----------华丽的分割线---------------");

        QiTianDaSheng deep = new QiTianDaSheng();
        QiTianDaSheng deepC = (QiTianDaSheng)deep.deepClone();
        System.out.println(deep.jinGuBang == deepC.jinGuBang);
        System.out.println("hashcode");
        System.out.println(deep.jinGuBang.hashCode());
        System.out.println(deepC.jinGuBang.hashCode());
    }
}
