package delegate;

public class FoodShop implements Shop{
    @Override
    public void description() {
        System.out.println("这是一家卖食物的店");
    }
}
