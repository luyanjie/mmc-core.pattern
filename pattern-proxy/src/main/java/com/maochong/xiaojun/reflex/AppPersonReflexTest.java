package com.maochong.xiaojun.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jokin
 * @date 2018/5/30 10:17
 * 反射获取Person类的三种方式
 */
public class AppPersonReflexTest {


    public static void main(String[] args) {
        // 方式一：根据名称获取 forName
        try {
            Class<?> clazz1 = Class.forName("com.maochong.xiaojun.reflex.Person");
            // 通过反射获取对象字段属性，并且赋值

            //构造函数(无参数)
            Constructor<?> constructor = clazz1.getConstructor();
            constructor.newInstance();
            // 构造函数(无参数) 也可以这么写
            Object object = clazz1.newInstance() ;
            //构造函数（一个参数）
            Constructor<?> constructor1 = clazz1.getConstructor(int.class);
            Person person = (Person) constructor1.newInstance(111);
            Method method = clazz1.getMethod("getUid");
            System.out.println((int)method.invoke(person));
            //构造函数（二个参数）
            Constructor<?> constructor2 = clazz1.getConstructor(int.class,String.class);
            Person person2 = (Person)constructor2.newInstance(1,"hao");
            Method method2 = clazz1.getMethod("getUid");
            System.out.println((int)method2.invoke(person2));
            Method method22 = clazz1.getMethod("getName");
            System.out.println((String)method22.invoke(person2));

           /*
            //创建实例
            Object person = clazz1.newInstance();
           //获得id 属性
            Field idField = clazz1.getDeclaredField( "uid" ) ;
            // 强制访问，不然private无法访问
            // 打破封装  实际上setAccessible是启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
            // 由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
            idField.setAccessible( true );
            //给id 属性赋值
            idField.set( person , 100) ;
            //打印 person 的属性值
            System.out.println( idField.get( person ));
            // 获取方法 getName
            Method method = clazz1.getMethod("setName",String.class);
            //打破封装
            method.setAccessible(true);
            //调用方法
            method.invoke(person,"jokin");
            //获取字段name
            Field nameField = clazz1.getDeclaredField("name");
            //打破封装
            nameField.setAccessible(true);
            // 打印 person 的 name 属性值
            System.out.println("Field getName:"+(String)nameField.get(person));
            //获取getName方法
            Method methodGetName = clazz1.getMethod("getName");
            System.out.println("invoke getName:"+(String)methodGetName.invoke(person));*/

            /*//通过反射，获取对象实例，并且操作对象的方法
            Person person = (Person)clazz1.newInstance();
            person.setUid(1);
            person.setName("n");
            System.out.println(person.toString());*/

           /* //创建实例
            Object object = clazz1.newInstance();
            Person person = (Person)object;
            person.read();*/

            /*//获取所有的属性
            Field[] fields = clazz1.getDeclaredFields();
            for (Field field:fields){
                System.out.println(field);
            }*/

            /*// 获取所有的构造函数
            Constructor<?>[] constructors = clazz1.getConstructors();
            for (Constructor c :constructors){
                System.out.println(c);
            }*/

            /*// 获取父类
            Class<?> superClass = clazz1.getSuperclass();
            System.out.println(superClass);*/

            /*// 获取所有的接口
            Class<?>[] interfaces = clazz1.getInterfaces();
            for (Class c : interfaces) {
                System.out.println(c);
            }
*/
            // 获取所有public 的公开方法
            /*Method[] methods = clazz1.getMethods();
            for (Method m:methods){
                System.out.println(m);
            }*/
            // 获取所有的方法(但是不会获取父类的方法)，包括private protected public
            /*Method[] methods1 = clazz1.getDeclaredMethods();
            for (Method m:methods1){
                System.out.println(m);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*// 方式二：class
        Class<?> class2 = Person.class;
        System.out.println(class2);

        // 方式三：getClass
        Person person = new Person();
        Class<?> clazz3 = person.getClass();
        System.out.println(clazz3);*/
    }
}
