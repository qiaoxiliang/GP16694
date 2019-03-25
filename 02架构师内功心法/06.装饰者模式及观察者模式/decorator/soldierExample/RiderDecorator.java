package decorator.soldierExample;

public class RiderDecorator extends SolderDecorator {
    public RiderDecorator(Soldier soldier) {
        super(soldier);
    }

    @Override
    public String rider() {
        return ",获得了一辆车";
    }
}
