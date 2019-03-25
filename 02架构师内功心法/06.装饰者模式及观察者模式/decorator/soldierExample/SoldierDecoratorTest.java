package decorator.soldierExample;

public class SoldierDecoratorTest {

    public static void main(String[] args) {
        Soldier soldier = new BaseSoldier();

        System.out.println("新兵，什么都没有，" + soldier.waepon() + "," + soldier.rider());

        soldier = new WeaponDecorator(soldier);

        System.out.println("获得了武器" +   soldier.waepon() + "," + soldier.rider());

        soldier = new RiderDecorator(soldier);

        System.out.println("老兵，什么都有" +   soldier.waepon() + "," + soldier.rider());
    }
}
