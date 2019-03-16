package com.prototype.deepClone;

import java.io.*;
import java.util.List;

public class DeepClone implements Cloneable,Serializable
{

    private int count;

    private String type;

    private List actinos;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List getActinos() {
        return actinos;
    }

    public void setActinos(List actinos) {
        this.actinos = actinos;
    }

    // 使用对象输出流和输入流的方式，使得即使是引用类型，也使用的是不同的地址
    public DeepClone deepClone(){


        DeepClone target = null;
                //将当前对象作为字节流输出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            // 将当前对象输出到内存中
            oos.writeObject(this);
            oos.flush();
            oos.close();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            target = (DeepClone) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return target;
    }
}
