package com.gp16694.lazySingleton;


public class LazySingletonFinalModify_InnerClass {

    private LazySingletonFinalModify_InnerClass(){

        System.out.println("实例化");
    }

    public static void doSomeThing(){

        System.out.println("do something");
    }

    /**
     * 由于内部类只有在使用它的这个类被加载时，才有在方法被调用前，有jvm来将其实例化，
     * jvm的规范保障了内部类在加载的时候，是线程安全的，所以没有了线程的问题。
     *
     * 而只有在使用的时候才实例化，有保障了延迟加载的功能。
     *
     * 所以使用静态内部类的方法时推荐实例化单例的方法
     * @return
     */
    public static LazySingletonFinalModify_InnerClass getInstance(){

        return LazySingletonFinalModify_InnerClassHolder.INSTANCE;
    }

    private static class LazySingletonFinalModify_InnerClassHolder{


        private final static LazySingletonFinalModify_InnerClass INSTANCE = new LazySingletonFinalModify_InnerClass();
    }
}
