package com.maochong.xiaojun.service;

/**
 * @author jokin
 * @date 2018/5/29 11:06
 * 实现接口
 */
public interface IService {
    /**
     * 工作
     * */
    void working();

    /**
     * 思考
     * */
    void thinking(boolean bl);
    /**
     * 休息
     * */
    void sleeping();
}
