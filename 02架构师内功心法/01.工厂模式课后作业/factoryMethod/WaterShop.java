package factoryMethod;

public class WaterShop implements Shop {
    @Override
    public String sell() {
        return "卖水的店";
    }
}
