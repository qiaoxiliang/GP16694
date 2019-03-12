package simpleFactory;

public class FoodShop implements Shop
{
    @Override
    public String sell() {
        return "卖食物的店";
    }
}
