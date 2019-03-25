package decorator.panCakeExample;

public class EggDecorator extends PanCakeDecorator{
    public EggDecorator(PanCake basePanCake) {
        super(basePanCake);
    }

    @Override
    public String getMst() {
        return super.getMst() + "加一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
