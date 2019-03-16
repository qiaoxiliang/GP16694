package com.prototype.prototypeExample;

import java.io.Serializable;

public class Weapon implements Serializable{

    private String longRangeWeapon;
    private String shortRangeWeapon;

    public String getLongRangeWeapon() {
        return longRangeWeapon;
    }

    public void setLongRangeWeapon(String longRangeWeapon) {
        this.longRangeWeapon = longRangeWeapon;
    }

    public String getShortRangeWeapon() {
        return shortRangeWeapon;
    }

    public void setShortRangeWeapon(String shortRangeWeapon) {
        this.shortRangeWeapon = shortRangeWeapon;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "longRangeWeapon='" + longRangeWeapon + '\'' +
                ", shortRangeWeapon='" + shortRangeWeapon + '\'' +
                '}';
    }
}
