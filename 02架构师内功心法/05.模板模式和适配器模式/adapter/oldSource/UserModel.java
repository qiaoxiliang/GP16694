package adapter.oldSource;

public class UserModel {

    private String userId;

    private String userName;

    private String PassWord;

    private String loginType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Override
    public String toString() {
        return "用户信息{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", loginType='" + loginType + '\'' +
                '}';
    }
}
