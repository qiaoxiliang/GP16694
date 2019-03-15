package com.gp16694.registerSingleton;

// 枚举式单例模式为饿汉模式
public enum EnumSingleton {

    INSTANCE;

    private Object date;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
