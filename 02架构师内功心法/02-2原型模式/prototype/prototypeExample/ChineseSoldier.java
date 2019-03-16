package com.prototype.prototypeExample;

import java.io.*;

public class ChineseSoldier extends Soldier implements Cloneable,Serializable{

    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "ChineseSoldier{" +
                "weapon=" + weapon +
                '}';
    }

    public Soldier deppClone(){

        Soldier taget = new Soldier();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            taget = (Soldier) ois.readObject();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return taget;

    }
}
