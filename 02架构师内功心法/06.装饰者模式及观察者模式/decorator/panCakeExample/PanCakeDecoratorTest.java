package decorator.panCakeExample;

public class PanCakeDecoratorTest {

    public static void main(String[] args) {

        PanCake basePanCake = new BasePanCake();
        System.out.println(basePanCake.getMst()  + "," + basePanCake.getPrice());

        basePanCake = new EggDecorator(basePanCake);
        System.out.println(basePanCake.getMst()  + "," + basePanCake.getPrice());
        System.out.println(basePanCake.getMst()  + "," + basePanCake.getPrice());


    }
}
