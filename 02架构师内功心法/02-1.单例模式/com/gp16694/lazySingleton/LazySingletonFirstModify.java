package com.gp16694.lazySingleton;

public class LazySingletonFirstModify {

    private LazySingletonFirstModify(){

    }

    private static LazySingletonFirstModify INSTANCE = null;

    /**
     * 此种修改解决的线程安全的问题，即在多线程抢占资源的时候，第一个访问的线程
     * 会抢先给程序加锁，是的后续的线程需要等到第一个执行结束后，才能进入该方法 ，
     * 而此时对象已经创建。
     *
     * 此种方法不好的地方在于，由于锁是加在了该类的静态方法上，所以等于直接锁住了该类，
     * 当多个线程抢占的时候，会占用大量的资源。
     * @return
     */
    public synchronized static  LazySingletonFirstModify getInstance(){

        if(INSTANCE == null){
            INSTANCE = new LazySingletonFirstModify();

        }

        return INSTANCE;

    }
}
