package com.maochong.xiaojun;

import com.maochong.xiaojun.service.ServiceLeaderImpl;

/**
 * @author jokin
 * @date 2018/5/29 11:18
 */
public class AppBossClient {
    public static void main(String[] args) {

        ServiceLeaderImpl.getInstance().sleeping();
        ServiceLeaderImpl.getInstance().working();

        ServiceLeaderImpl.getInstance().doB().working();
        ServiceLeaderImpl.getInstance().doB().sleeping();

        ServiceLeaderImpl.getInstance().sleeping();
        ServiceLeaderImpl.getInstance().working();

        ServiceLeaderImpl.getInstance().thinking(false);
        ServiceLeaderImpl.getInstance().thinking(true);
    }
}
