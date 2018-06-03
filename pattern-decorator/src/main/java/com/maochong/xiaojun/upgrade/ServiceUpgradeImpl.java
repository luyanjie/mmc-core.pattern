package com.maochong.xiaojun.upgrade;

import com.maochong.xiaojun.MessageResponse;
import com.maochong.xiaojun.old.IServiceDecorator;

/**
 * @author jokin
 * @date 2018/6/3 0003 0:52
 */
public class ServiceUpgradeImpl implements IServiceUpgrade {

    /**
     * 旧版本的登录注册接口，看新版是否需要继承
     * */
    private IServiceDecorator iServiceDecorator;
    public ServiceUpgradeImpl(IServiceDecorator iServiceDecorator){
        this.iServiceDecorator = iServiceDecorator;
    }

    @Override
    public MessageResponse login(String userName, String password) {
        return this.iServiceDecorator.login(userName,password);
    }

    @Override
    public MessageResponse register(String userName, String password) {
        return this.iServiceDecorator.register(userName,password);
    }


    @Override
    public MessageResponse loginForQQ(String openId) {
        return new MessageResponse<>(200,"login for qq success","openId:"+openId);
    }

    @Override
    public MessageResponse loginForWechat(String openId) {
        return new MessageResponse<>(200,"login for wechat success","openId:"+openId);
    }

    @Override
    public MessageResponse loginForToken(String token) {
        return new MessageResponse<>(200,"login for qq token","token:"+token);
    }

    @Override
    public MessageResponse loginForTelephone(String telephone, String code) {
        return new MessageResponse<>(200,"login for telephone",new String[]{telephone,code});
    }

    @Override
    public MessageResponse loginForRegister(String username, String password) {
        return new MessageResponse<>(200,"login for register",new String[]{username,password});
    }
}
