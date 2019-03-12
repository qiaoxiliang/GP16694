package simpleFactory;

public class NotOpenShop implements Shop {
    @Override
    public String sell() {
        return "此种类型的店铺还没有开业";
    }
}
