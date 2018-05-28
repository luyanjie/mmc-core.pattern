package com.maochong.xiaojun.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author jokin
 * @date 2018/5/27 0027 14:33
 * jdk动态代理
 */
public class AppJdkProxyTest {
    public static void main(String[] args) {
        try {
            JdkProxy proxy = new JdkProxy();
            Calculator calculator = (Calculator)proxy.getInstance(new CalculatorImpl());
            System.out.println("==相加=="+calculator.add(1,2));

            System.out.println("==相除=="+calculator.devide(20,10));

            System.out.println("==相乘=="+calculator.multiply(100,200));

            System.out.println("==相减=="+calculator.subtract(1000,2000));

            // 动态代理的原理
            // 1、拿到被代理的对象的引用，并且获取到她的所有的接口，反射获取
            // 2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有接口
            // 3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
            // 4、编译新生成的Java代码.class字节码文件
            // 5、在重新加载到JVM中运行

            // JDK中有个规范，只要是&开头的一般都是自动生成的，动态代理是动态生成的字节码文件，在使用代理的时候生成

            // 通过反射编译工具可以查看源代码
            System.out.println("======华丽的分割线======");
            // 输出：class com.sun.proxy.$Proxy0
            System.out.println(calculator.getClass());
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Calculator.class});
            FileOutputStream os = new FileOutputStream("E:\\data\\$Proxy0.class");
            os.write(bytes);
            os.close();
            // 查看 E:\data\$Proxy0.class 就可以一目了然它的怎么实现的 com.maochong.xiaojun.jdkproxy.JdkProxy.invoke的方法是怎么定义的了

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
