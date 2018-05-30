package com.maochong.xiaojun.reflex;

/**
 * @author jokin
 * @date 2018/5/30 10:22
 * 实现类
 */
public class Person implements IPerson {

    private int uid;
    private String name;
    private String address;

    public Person(){
        System.out.println("构造函数没参数");
    }
    public Person(int uid) {
        this.uid = uid;
    }

    public Person(int uid,String name){
        this.uid = uid;
        this.name = name;
    }

    public Person(int uid,String name,String address){
        this.uid = uid;
        this.name = name;
        this.address = address;
    }

    private void doSomething(){
        System.out.println("doSomething");
    }

    protected void getSomething(){
        System.out.println("getSomething");
    }

    @Override
    public void read() {
        System.out.println("我正在阅读文献.....");
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
