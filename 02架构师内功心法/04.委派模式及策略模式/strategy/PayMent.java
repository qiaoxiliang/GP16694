package strategy;

import strategy.payStrategy.PayMehod;
import strategy.payStrategy.PayMethodFactory;

public class PayMent {


    public void pay(Order order,String payMethod){

        // 通过工厂获取付款方式
        PayMehod payMehod = PayMethodFactory.getPayMethod(payMethod);

        System.out.println(payMehod.realPay(order));
    }
}
