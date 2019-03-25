package decorator.soldierExample;

import java.net.Socket;

public class BaseSoldier implements Soldier{
    @Override
    public String waepon() {
        return "没有武器";
    }

    @Override
    public String rider() {
        return "没有骑具";
    }
}
