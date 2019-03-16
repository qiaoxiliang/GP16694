package com.prototype.prototypeExample;

public class ChineseSoldierTetst {

    public static void main(String[] args) {
        ChineseSoldier cs = new ChineseSoldier();

        cs.setCountry("中国");
        cs.setType("陆军 ");
        Weapon weapon = new Weapon();
        weapon.setLongRangeWeapon("95式");
        weapon.setShortRangeWeapon("三棱军刺");
        cs.setWeapon(weapon);
        ChineseSoldier cs1 = (ChineseSoldier) ChineseSoldierFactory.makeSolder(cs);
        ChineseSoldier cs2 = (ChineseSoldier) ChineseSoldierFactory.makeSolder(cs);
        ChineseSoldier cs3 = (ChineseSoldier) ChineseSoldierFactory.makeSolder(cs);

        System.out.println(cs);
        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs3);

        System.out.println(cs.getWeapon().hashCode());
        System.out.println(cs1.getWeapon().hashCode());
        System.out.println(cs2.getWeapon().hashCode());
        System.out.println(cs3.getWeapon().hashCode());
    }
}
