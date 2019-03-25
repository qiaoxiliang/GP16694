package decorator.soldierExample;

public class SolderDecorator implements Soldier{

    Soldier soldier;

    public SolderDecorator(Soldier soldier){
        this.soldier = soldier;

    }

    @Override
    public String waepon() {
        return soldier.waepon();
    }

    @Override
    public String rider() {
        return soldier.rider();
    }
}
