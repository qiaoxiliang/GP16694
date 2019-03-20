package delegate;

/**
 * 客户类
 */
public class Client {

    public void commond(String commond){

        Intermediary intermediary = new Intermediary();
        intermediary.find(commond);

    }
}
