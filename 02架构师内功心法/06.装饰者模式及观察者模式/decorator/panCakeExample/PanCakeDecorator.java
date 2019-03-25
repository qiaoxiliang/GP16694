package decorator.panCakeExample;

public class PanCakeDecorator implements PanCake{

    private PanCake basePanCake;

    public PanCakeDecorator(PanCake basePanCake){
        this.basePanCake = basePanCake;
    }

    @Override
    public String getMst() {
        return this.basePanCake.getMst();
    }

    @Override
    public int getPrice() {
        return this.basePanCake.getPrice();
    }
}
