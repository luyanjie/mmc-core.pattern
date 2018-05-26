package com.maochong.xiaojun.seriable;

import java.io.*;

/**
 * @author jokin
 * @date 2018/5/25 11:20
 */
public class AppSerializable {
    public static void main(String[] args) {
        // 序列化是单例

        SerializableSingleton s1 = null;
        SerializableSingleton s2 = SerializableSingleton.getInstance();

        try {
            FileOutputStream fos =  new FileOutputStream("E：/Serializable.org");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("E：/Serializable.org");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 =  (SerializableSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);


            /*
            在SerializableSingleton 中添加以下重写 就可以达到s1 = s2了
            public Object readResolve(){
                return INSTANCE;
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
