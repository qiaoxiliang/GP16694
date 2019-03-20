package strategy.payStrategy;

import strategy.Order;
import strategy.PayResult;

public abstract class PayMehod {

    public abstract String getName();

    public abstract double getBalance();

    public PayResult realPay(Order order){

        PayResult result = null;

        // 获取余额
        double balance = getBalance();

        // 获取支付金额
        double amout = order.getAmout();

        // 如果支付金额大于余额，则支付失败
        if(amout > balance){

            result = new PayResult();
            result.setCode("-100");
            result.setPayMethodName(this.getName());
            result.setMsg("支付失败");
            return result;

        }else{
            result = new PayResult();
            result.setCode("100");
            result.setPayMethodName(this.getName());
            result.setMsg("支付成功");
            return result;
        }

    }
}
