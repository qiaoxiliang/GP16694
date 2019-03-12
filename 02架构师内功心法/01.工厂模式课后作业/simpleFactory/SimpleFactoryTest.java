package simpleFactory;

public class SimpleFactoryTest {

    public static void main(String[] args) {

        System.out.println(ShopFactory.chooseShop("food").sell());
        System.out.println(ShopFactory.chooseShop("water").sell());
        System.out.println(ShopFactory.chooseShop("").sell());
    }
}
