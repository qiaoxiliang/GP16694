package selfProxy;

public class HouseIntermediary implements Intermediary {
    @Override
    public String forBuyer() {
        return "提供租房服务";
    }

    @Override
    public void forSeller() {
        System.out.println("发布招租信息");;
    }
}
