package jdkDynamicProxy;

public interface Intermediary {

    // 为买方提供服务
    String forBuyer();

    // 为卖方提供服务
    void forSeller();
}
