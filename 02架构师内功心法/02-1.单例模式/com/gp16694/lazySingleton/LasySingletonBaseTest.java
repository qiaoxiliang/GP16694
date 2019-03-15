package com.gp16694.lazySingleton;

import com.gp16694.Executor;

public class LasySingletonBaseTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Executor());
        Thread t2 = new Thread(new Executor());

        t1.start();
        t2.start();
    }
}
