package com.gp16694.lazySingleton;

public class LazySingletonBase {



    // 由于要拿到静态 方法中赋值，所以此处不使用final修饰
    private static LazySingletonBase INSTANCE =  null;

    private LazySingletonBase() {
    }

    /**
     * 此种写法会出现线程 安全的问题，即一旦线程多个线程同时 进入到
     * INSTANCE = new LazySingletonBase();时就会存在多个实例
     * @return
     */
    public static LazySingletonBase getInstance(){

        if(INSTANCE == null){

            INSTANCE = new LazySingletonBase();
        }

        return INSTANCE;
    }

}
