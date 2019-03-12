package abstractFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        ComputerAccessoriesFactory common = new CommonComputerAccessoriesFactory();
        ComputerAccessoriesFactory luxury = new LuxuryComputerAccessoriesFactory();

        System.out.println("普通人使用普通的电脑配件");
        System.out.println(common.useKeyBoard().click());
        System.out.println(common.useMouse().move());

        System.out.println("----------------------------");
        System.out.println("有钱人使用奢侈的电脑配件");
        System.out.println(luxury.useKeyBoard().click());
        System.out.println(luxury.useMouse().move());
    }
}
