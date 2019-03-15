package com.gp16694.hungrySingleton;

import java.io.Serializable;

public class HungrySingleton implements Serializable{

    private HungrySingleton(){

        if(INSTANCE != null){

            throw  new RuntimeException("不能通过反射重复创建实例");
        }

        System.out.println("在类被加载的时候，就创建了实例");
    }

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance(){

        return INSTANCE;
    }

    public static void doSomeThing(){

        System.out.println("doThings");
    }

    private Object readResolve(){

        return INSTANCE;
    }
}
