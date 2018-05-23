package com.maochong.xiaojun.unified;

/**
 * @author jokin
 * @date 2018/5/23 17:05
 * 带参数的构造函数
 */
public class ServiceAbstractParameter extends AbstractSingleton{

    private final int value;

    /**
     * 构造函数创建实例只能new 不然报错
     */
    public ServiceAbstractParameter(int value) throws SingletonException {
        super();
        this.value = value;
    }

    public static ServiceAbstractParameter getInstance(int value)
    {
        try {
            return AbstractSingleton.getInstanceParameter(ServiceAbstractParameter.class,new Class[]{int.class},new Object[]{value});
        }
        catch (Exception ex)
        {
            System.out.println(ex.fillInStackTrace());
            return null;
        }
    }

    public int getValue(){
        return  this.value;
    }
}
