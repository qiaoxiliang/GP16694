package adapter.newSource;

import adapter.newSource.factory.LoginFactory;
import adapter.oldSource.LoginService;
import adapter.oldSource.UserModel;

public class NewLoginService  extends LoginService{


    public void login(UserModel model){

        super.login(model);
    }

    public void weChatLogin(UserModel model){

        LoginFactory.getInstance(model.getLoginType()).login();
    }
    public void qqLogin(UserModel model){

        LoginFactory.getInstance(model.getLoginType()).login();
    }

    public void sinaLogin(UserModel model){

        LoginFactory.getInstance(model.getLoginType()).login();
    }

    public void mobileLogin(UserModel model){

        LoginFactory.getInstance(model.getLoginType()).login();
    }

}
