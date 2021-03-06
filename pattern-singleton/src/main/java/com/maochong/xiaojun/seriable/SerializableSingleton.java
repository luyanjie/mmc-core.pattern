package com.maochong.xiaojun.seriable;

import java.io.Serializable;

/**
 * @author jokin
 * @date 2018/5/25 11:17
 * 序列化式单例
 */
public class SerializableSingleton implements Serializable {
    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //内存中状态给永久保存下来了

    //反序列化
    //讲已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象
    //在转换过程中会重新创建对象new

    private SerializableSingleton(){}

    private final static SerializableSingleton INSTANCE = new SerializableSingleton();

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

    public Object readResolve(){
        return INSTANCE;
    }
}
