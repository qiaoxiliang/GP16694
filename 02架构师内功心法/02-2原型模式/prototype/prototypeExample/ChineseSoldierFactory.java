package com.prototype.prototypeExample;

public class ChineseSoldierFactory{

    private ChineseSoldierFactory(){

    }

    public static Soldier makeSolder(Soldier soldier){

        return soldier.deppClone();
    }

}
