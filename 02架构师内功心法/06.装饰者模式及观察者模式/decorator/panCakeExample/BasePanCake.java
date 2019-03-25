package decorator.panCakeExample;

public class BasePanCake implements PanCake{
    @Override
    public String getMst() {
        return "1张煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
