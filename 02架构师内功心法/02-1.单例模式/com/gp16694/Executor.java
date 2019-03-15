package com.gp16694;

import com.gp16694.lazySingleton.LazySingletonFinalModify_InnerClass;
import com.gp16694.registerSingleton.ContainerSingleton;
import com.gp16694.threadLocalSingleton.ThreadLocalSingleton;


public class Executor implements Runnable{

    private String classPath ;

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public void run() {
        //LazySingletonBase instance = LazySingletonBase.getInstance();
        //LazySingletonFirstModify instance = LazySingletonFirstModify.getInstance();
        //LazySingletonSecondModify_DoubleCheck instance = LazySingletonSecondModify_DoubleCheck.getInstance();
       // LazySingletonFinalModify_InnerClass instance = LazySingletonFinalModify_InnerClass.getInstance();
        //ContainerSingleton instance = ContainerSingleton.getBean(classPath);
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        //Object instance = ContainerSingleton.getBean(classPath);
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
