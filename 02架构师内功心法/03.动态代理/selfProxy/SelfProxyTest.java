package selfProxy;

public class SelfProxyTest {

    public static void main(String[] args) {
        SelfDynamicProxy selfDynamicProxy =  new SelfDynamicProxy();

        Intermediary Intermediary = selfDynamicProxy.getInstance(new HouseIntermediary());

        System.out.println(Intermediary.forBuyer());

        System.out.println("---------------------------");

        Intermediary.forSeller();
    }
}
