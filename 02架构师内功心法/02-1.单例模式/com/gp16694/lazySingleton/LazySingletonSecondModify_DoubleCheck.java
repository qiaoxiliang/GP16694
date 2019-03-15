package com.gp16694.lazySingleton;

public class LazySingletonSecondModify_DoubleCheck {

    private LazySingletonSecondModify_DoubleCheck(){

    }

    private static volatile LazySingletonSecondModify_DoubleCheck INSTANCE = null;

    /**
     * 此种方法并不是将整个类上锁，而只是将类内部的方法上锁，这样在用户调用该类的其他
     * 方法时并不会出现阻塞的现象，也提高了性能
     * @return
     */
    public static LazySingletonSecondModify_DoubleCheck getInstance(){

        if(INSTANCE == null){
            synchronized (LazySingletonSecondModify_DoubleCheck.class){

                /**
                 * 此处为什么还要加上一个null的判断
                 * 是因为当jvm虚拟机实例化一个类的时候，通常要做三件事情
                 * 1.分配内存给这个类
                 * 2.初始化对象
                 * 3.设置lazy指向刚分配的内存地址
                 * 所以当多线程的时候，很有可能第一个获得锁的线程还没有完成类的初始化，
                 * 第二个线程就已经通过类第一个null判断，而进入阻塞状态，所以即使此时线程完成了
                 * 初始话，但是如果没有第二个空判断的话，这个单例还是会被再一次实例化
                 * 4.由于jvm的乱序执行原理，2和3并不是顺序执行的，所以可能先执行3指向内存地址是时，第二个线程就过来了，
                 * 发现INSTANCE不为 null就直接返回使用了，然而此时其实分配的内存地址并没有被初始化，这样使用起来就抛出了异常，
                 * 因此要在定义INSTANCE之前加上volatile，确保每一次都是从主内存中读取
                 *
                 */
                if(INSTANCE == null){
                    INSTANCE = new LazySingletonSecondModify_DoubleCheck();
                }
            }
        }

        return INSTANCE;
    }


}
