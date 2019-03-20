package delegate;

public class HouseShop implements Shop{
    @Override
    public void description() {
        System.out.println("这是一家出售房产的店");
    }
}
