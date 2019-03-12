package abstractFactory;

public class CommonKeyBoard implements KeyBoard{
    @Override
    public String click() {
        return "点击普通键盘";
    }
}
