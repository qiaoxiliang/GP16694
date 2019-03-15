package com.gp16694.registerSingleton;

import java.util.HashMap;
import java.util.Map;

public class ContainerSingleton {

    private ContainerSingleton(){

    }

    private static Map<String,Object> ioc = new HashMap<String,Object>();

    public static Object getBean(String classPath){

        synchronized (ioc){

            // 如果容器中不存在
            if(!ioc.containsKey(classPath)){

                // 根据类路径获取类的实例
                Object o = null;
                try {
                    o = Class.forName(classPath);

                    ioc.put(classPath,o);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return o;
            } else {
                return ioc.get(classPath);
            }

        }

    }

}
