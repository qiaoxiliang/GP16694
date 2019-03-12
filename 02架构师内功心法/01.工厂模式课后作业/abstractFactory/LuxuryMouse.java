package abstractFactory;

public class LuxuryMouse implements Mouse{
    @Override
    public String move() {
        return "移动昂贵的鼠标";
    }
}
