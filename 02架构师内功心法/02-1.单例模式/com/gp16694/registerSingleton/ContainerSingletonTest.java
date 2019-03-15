package com.gp16694.registerSingleton;

import com.gp16694.Executor;

public class ContainerSingletonTest {

    public static void main(String[] args) {

        Executor executor = new Executor();

        executor.setClassPath("com.gp16694.registerSingleton.EnumSingleton");

        Thread t1 = new Thread(executor);
        Thread t2 = new Thread(executor);
        Thread t3 = new Thread(executor);
        Thread t4 = new Thread(executor);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
