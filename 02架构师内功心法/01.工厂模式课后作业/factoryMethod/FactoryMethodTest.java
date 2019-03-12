package factoryMethod;

public class FactoryMethodTest {

    public static void main(String[] args) {
        Factory foodFactory = new FoodShopFactory();
        Factory waterFactory = new WaterShopFactory();

        System.out.println(foodFactory.getShop().sell());
        System.out.println(waterFactory.getShop().sell());
    }
}
