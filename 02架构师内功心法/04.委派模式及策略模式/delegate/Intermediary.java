package delegate;

/**
 * 中介类
 */
public class Intermediary {

    public void find(String type){

        Shop shop = null;

        if("house".equals(type)){

            shop = new HouseShop();
        }

        if("food".equals(type)){
            shop = new FoodShop();
        }

        shop.description();
    }
}
