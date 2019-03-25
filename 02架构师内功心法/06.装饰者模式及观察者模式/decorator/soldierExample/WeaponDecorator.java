package decorator.soldierExample;

public class WeaponDecorator extends SolderDecorator{
    public WeaponDecorator(Soldier soldier) {
        super(soldier);
    }

    @Override
    public String waepon() {
        return "，获得了一把枪";
    }
}
