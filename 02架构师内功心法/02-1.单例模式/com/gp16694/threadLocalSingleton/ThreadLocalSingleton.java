package com.gp16694.threadLocalSingleton;

public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){

    }

    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return INSTANCE.get();
    }

}

