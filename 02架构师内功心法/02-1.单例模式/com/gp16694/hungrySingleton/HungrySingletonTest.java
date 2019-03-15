package com.gp16694.hungrySingleton;

public class HungrySingletonTest {

    public static void main(String[] args) {
        /**
         * 优点：没有加任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好。
         * 缺点：类加载的时候就初始化，不管用与不用都占着空间，浪费了内存。
         */

        /**
         * 此时只是调用了类中其他的方法，并没有调用获取单例的方法 ，该类依然会被实例化
         */
        HungrySingleton.doSomeThing();
    }
}
