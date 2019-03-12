package factoryMethod;

public class FoodShopFactory implements  Factory{
    @Override
    public Shop getShop() {
        return new FoodShop();
    }
}
