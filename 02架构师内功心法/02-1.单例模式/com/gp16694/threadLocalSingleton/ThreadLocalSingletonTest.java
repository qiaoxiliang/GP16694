package com.gp16694.threadLocalSingleton;

import com.gp16694.Executor;

public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new Executor());
        Thread t2 = new Thread(new Executor());

        t1.start();
        t2.start();
    }
}
