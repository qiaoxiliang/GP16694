package jdkDynamicProxy;

public class FoodIntermediary implements Intermediary{
    @Override
    public String forBuyer() {
        return "叫外卖";
    }

    @Override
    public void forSeller() {
        System.out.println("卖饭");
    }
}
