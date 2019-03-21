package adapter.newSource;

import adapter.newSource.factory.LoginFactory;
import adapter.oldSource.UserModel;

public class LoginadapterTest {

    public static void main(String[] args) {

        UserModel model = new UserModel();

        NewLoginService newLoginService = new NewLoginService();
        newLoginService.login(model);
        System.out.println("-------------------------------------");
        model.setLoginType(LoginFactory.MOBILE);
        newLoginService.mobileLogin(model);
        System.out.println("-------------------------------------");
        model.setLoginType(LoginFactory.WE_CHAT);
        newLoginService.weChatLogin(model);
        System.out.println("-------------------------------------");
        model.setLoginType(LoginFactory.SINA);
        newLoginService.sinaLogin(model);

    }
}
