package adapter.newSource;

import adapter.newSource.adapter.LoginAdapter;

public class SinaLoginAdapter implements LoginAdapter{
    @Override
    public void extendProcess() {
        System.out.println("新浪微博的前置处理。");
    }

    @Override
    public void login() {

        extendProcess();
        System.out.println("微博登录。");

    }
}
