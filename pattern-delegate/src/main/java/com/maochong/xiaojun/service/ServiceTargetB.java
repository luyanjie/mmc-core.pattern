package com.maochong.xiaojun.service;


/**
 * @author jokin
 * @date 2018/5/29 11:05
 * 处理者A
 */
public class ServiceTargetB implements IService{
    @Override
    public void working() {
        System.out.println("处理者B接到工作请求...开始工作");
    }

    @Override
    public void sleeping() {
        System.out.println("处理者B接到休息请求...开始休息");
    }

    @Override
    public void thinking(boolean bl) {
        System.out.println("处理者B接到思考请求...开始思考"+ bl);
    }
}
