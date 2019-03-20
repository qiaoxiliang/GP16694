package strategy;

import strategy.payStrategy.PayMethodFactory;

public class StrategyTest {

    public static void main(String[] args) {
        Order order = new Order();

        order.setUserId("1");
        order.setOrderId("1");
        order.setAmout(450);

        PayMent payMent = new PayMent();

        payMent.pay(order, PayMethodFactory.WE_CHAT);

    }
}
