package com.gp16694.destroySingleton;

import com.gp16694.hungrySingleton.HungrySingleton;
import com.gp16694.registerSingleton.EnumSingleton;

import java.io.*;

// 使用序列化和反序列化的方式来破坏单例模式
public class SerializableDestorySingleton {

    //序列化
    // 序列化就是通过将内存中保存的类的状态，将其转换成字节码
    // 通过IO流，写入到其他地方，磁盘/文件,从而将内存中的状态
    // 永久的保存下来

    // 反序列化
    // 将已经持久化好的字节码文件，转换为IO流，加载到内存
    // 通过IO流的读取，最终在转化为java的对象
    // 在转化的过程中，java会重新创建对象

    public static void main(String[] args) {
        // 源对象
        EnumSingleton source = EnumSingleton.getInstance();
        // 反序列化后得到的java对象
        EnumSingleton target = null;
        Object o = new Object();
        source.setDate(o);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            // 将source对象输出到HungrySingleton.obj文件中
            fos = new FileOutputStream("HungrySingleton.obj");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(source);
            oos.flush();
            oos.close();

            // 从文件HungrySingleton.obj将对象读取回来，并赋值到target中
            fis = new FileInputStream("HungrySingleton.obj");
            ois = new ObjectInputStream(fis);
            target = (EnumSingleton) ois.readObject();
            ois.close();;

            System.out.println(source.getDate());
            System.out.println(target.getDate());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






}
