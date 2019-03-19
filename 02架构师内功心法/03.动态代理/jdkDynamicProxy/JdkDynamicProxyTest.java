package jdkDynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class JdkDynamicProxyTest {

    public static void main(String[] args) throws IOException {
        DynamicIntermediaryProxy proxy = new DynamicIntermediaryProxy();

        HouseIntermediary houseIntermediary = new HouseIntermediary();

        Intermediary intermediary = proxy.getInstance(houseIntermediary);

        System.out.println(intermediary.forBuyer());

        System.out.println("---------------------------------");

        intermediary.forSeller();

        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Intermediary.class});
        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
