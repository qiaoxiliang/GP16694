package abstractFactory;

public class LuxuryKeyBoard implements KeyBoard{
    @Override
    public String click() {
        return "点击昂贵的键盘";
    }
}
