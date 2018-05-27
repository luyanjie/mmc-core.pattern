package com.maochong.xiaojun.custom;


import org.apache.commons.lang3.StringUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @auther jokin
 * @data 2018/5/27 0027 20:54
 * 自己实现JDK动态代理
 */
public class MProxy {

    private static final String ln = "\r\n";

    private static int num = 0;

    public static Object newProxyInstance(MClassLoader classLoader, Class<?>[] interfaces, MInvocationHandler h) {

        String proxyName = "$Proxy" + (num++);
        try {

            //1、 动态生成源代码.java 文件
            String src = generateSrc(interfaces, proxyName);
            //2、 Java文件输出到指定文件目录
            String filePath = MProxy.class.getResource("").getPath();
            System.out.println("文件目录:" + filePath);
            File f = new File(filePath + StringUtils.join(proxyName, ".java"));
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4、编译生成的.class文件加载到jvm中来，使用自定义类加载器MClassLoad
            Class<?> proxyClass = classLoader.findClass(proxyName);
            Constructor c = proxyClass.getConstructor(MInvocationHandler.class);
            // 删除生成的java文件
             f.delete();

            // 5、 返回字节码重组以后新的代理对象
            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSrc(Class<?>[] interfaces, String proxyName) {
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(MProxy.class.getPackage().getName()).append(";").append(ln);
        sb.append("import ").append("java.lang.reflect.Method;").append(ln);
        //sb.append("import ").append(interfaces[0].getClass().getPackage().getName()+"."+interfaces[0].getName()).append(";").append(ln);

        // import
        Arrays.stream(interfaces).forEach(x->
            sb.append("import ").append(x.getName()).append(";").append(ln)
        );

        // class
        sb.append("public class ").append(proxyName).append(" implements ");

        StringBuilder sbInterfaces = new StringBuilder();
        Arrays.stream(interfaces).forEach(x->{
            String name = x.getName();
            sbInterfaces.append(name.substring(name.lastIndexOf(".")+1)).append(",");
        });

        sb.append(sbInterfaces.substring(0,sbInterfaces.lastIndexOf(",")));

        sb.append("{").append(ln);

        sb.append("MInvocationHandler h;" + ln);

        sb.append("public $Proxy0(MInvocationHandler h) { " + ln);

        sb.append("this.h = h;");

        sb.append("}" + ln);

        Arrays.stream(interfaces).forEach(x-> {

            String mName = x.getName().substring(x.getName().lastIndexOf(".")+1);
                    for (Method m : x.getMethods()) {

                        // 判断方法参数
                        Parameter[] parameters = m.getParameters();
                        StringBuilder sbParameter = new StringBuilder();
                        // 参数值
                        StringBuilder args = new StringBuilder();
                        // 参数类型
                        StringBuilder classes = new StringBuilder();
                        // Arrays.stream(args).forEach(x->x=x+",");
                        for (Parameter parameter : parameters) {
                            classes.append(parameter.getType()).append(".class").append(",");
                            args.append(parameter.getName()).append(",");
                            sbParameter.append(parameter.getType()).append(" ").append(parameter.getName()).append(",");
                        }

                        // 设置方法
                        sb.append("public ").append(m.getReturnType().getName()).append(" ").append(m.getName()).append("(");
                        if (sbParameter.length() > 0) {
                            sb.append(sbParameter.substring(0, sbParameter.lastIndexOf(",")));
                        }
                        sb.append(") {" + ln);
                        sb.append("try{" + ln);
                        sb.append("Method m = ").append(mName).append(".class.getMethod(\"").append(m.getName()).append("\",new Class[]{");
                        // 传入参数类型
                        sb.append(classes.length() <= 0 ? "" : classes.substring(0, classes.lastIndexOf(",")));
                        sb.append("});").append(ln);
                        sb.append("this.h.invoke(this,m,");
                        // 参数值
                        sb.append(args.length() <= 0 ? "null" : StringUtils.join("new Object[]{", args.substring(0, args.lastIndexOf(",")), "}"));
                        sb.append(");").append(ln);
                        sb.append("}catch(Throwable e){" + ln);
                        sb.append("e.printStackTrace();" + ln);
                        sb.append("}");
                        sb.append("}");
                    }

                });
        sb.append("}" + ln);
        return sb.toString();
    }
}
