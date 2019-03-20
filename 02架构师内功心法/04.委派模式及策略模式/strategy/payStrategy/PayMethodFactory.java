package strategy.payStrategy;

import java.util.HashMap;
import java.util.Map;

// 使用简单工厂模式对策略进行集中管理
public class PayMethodFactory {

    public static String AI_PAY = "Ali";
    public static String WE_CHAT = "WeChat";



    private static Map<String,PayMehod> payMehodMap = new HashMap<String,PayMehod>();

    static{

        payMehodMap.put(AI_PAY, new AliPay());
        payMehodMap.put(WE_CHAT, new WeChatPay());
    }

    public static  PayMehod  getPayMethod(String method){

        return payMehodMap.get(method);

    }
}
