package com.maochong.xiaojun.unified;

/**
 * @author jokin
 * @date 2018/5/23 16:54
 * 不带参数的构造函数
 */
public class ServiceAbstract extends AbstractSingleton {

    public ServiceAbstract() throws SingletonException{
        super();
    }

    public static ServiceAbstract getInstanceClass(){
        try {
            return AbstractSingleton.getInstance(ServiceAbstract.class);
        }
        catch (Exception ex){
            return null;
        }
    }

    public static ServiceAbstract getInstanceName(){
        try {
            return (ServiceAbstract)AbstractSingleton.getInstance(ServiceAbstract.class.getName());
        }
        catch (Exception ex){
            return null;
        }
    }
    public String getString(String value){
        return  value;
    }
}
