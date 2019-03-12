package simpleFactory;

public class ShopFactory {

    private ShopFactory(){

    }

    public static Shop chooseShop(String type){

        if("food".equals(type)){

            return new FoodShop();
        }

        if("water".equals(type)){

            return new WaterShop();
        }


        return new NotOpenShop();
    }
}
