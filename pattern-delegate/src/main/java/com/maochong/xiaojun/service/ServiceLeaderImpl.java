package com.maochong.xiaojun.service;

/**
 * @author jokin
 * @date 2018/5/29 11:10
 * 工作调度、分配者，实际不干活
 */
public class ServiceLeaderImpl implements IService{

    private ServiceLeaderImpl(){}

    /**
     * 获取单例
     * */
    public static ServiceLeaderImpl getInstance(){
        return LazyHolder.LAZY;
    }

    /**
     * 内部静态类
     * */
    private static class LazyHolder{
        private static final ServiceLeaderImpl LAZY = new ServiceLeaderImpl();
    }

    /**
     * 委派给A干活
     * */
    private IService iService = new ServiceTargetA();

    @Override
    public void working() {
        iService.working();
    }

    @Override
    public void thinking(boolean bl) {
        iService = (IService)new ServiceJdkProxy().getInstance(bl? new ServiceTargetA():new ServiceTargetB());
        iService.thinking(bl);
    }

    @Override
    public void sleeping() {
        iService.sleeping();
    }

    /**
     * 让A干活
     * */
    public ServiceLeaderImpl doA(){
        iService = new ServiceTargetA();
        return LazyHolder.LAZY;
    }

    /**
     * 让B干活
     * */
    public ServiceLeaderImpl doB(){
        iService = new ServiceTargetB();
        return LazyHolder.LAZY;
    }
}
