package adapter.newSource;

import adapter.newSource.adapter.LoginAdapter;

public class WechatLoginAdapter implements LoginAdapter{
    @Override
    public void extendProcess() {
        System.out.println("微信的前置处理。");
    }

    @Override
    public void login() {
        extendProcess();
        System.out.println("微信登录。");
    }
}
