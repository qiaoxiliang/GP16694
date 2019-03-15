package com.gp16694.destroySingleton;

import com.gp16694.hungrySingleton.HungrySingleton;
import com.gp16694.lazySingleton.LazySingletonBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射破坏单例模式
 */
public class ReflectionDestorySingleton {

    public static void main(String[] args) {
        // 获取实例的Class
        Class clazz = HungrySingleton.class;

        try {

            // 获取无参的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);

            // 设置强制访问
            c.setAccessible(true);

           Object o1 = c.newInstance();
           Object o2 = c.newInstance();

            System.out.println(o1 == o2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
