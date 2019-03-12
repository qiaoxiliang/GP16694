package factoryMethod;


public class WaterShopFactory implements Factory{
    @Override
    public Shop getShop() {
        return new WaterShop();
    }
}
