package strategy.payStrategy;

// 使用策略模式来实现在不同种支付方式不同策略
public class AliPay extends PayMehod {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double getBalance() {
        return 500;
    }
}
