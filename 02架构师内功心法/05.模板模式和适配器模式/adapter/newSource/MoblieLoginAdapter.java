package adapter.newSource;

import adapter.newSource.adapter.LoginAdapter;

public class MoblieLoginAdapter implements LoginAdapter{
    @Override
    public void extendProcess() {
        System.out.println("移动端的前置处理。");
    }

    @Override
    public void login() {
        extendProcess();
        System.out.println("移动端登录。");
    }
}
