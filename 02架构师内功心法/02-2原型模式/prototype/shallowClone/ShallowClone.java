package com.prototype.shallowClone;

import java.util.List;

public class ShallowClone implements Cloneable{

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

    //此种方式为浅克隆的方式，这种方式的缺点的是，
    //在克隆引用类型时，由于引用类型传递的是地址，
    //导致克隆前的对象和克隆后的对象，都具有同样的引用
    //一旦该引用类型发生变化 ，则两个对象全部发生变化
    public ShallowClone shallowClone(){

        ShallowClone target = new ShallowClone();
        target.setActinos(this.actinos);
        target.setCount(this.count);
        target.setType(this.type);

        return target;

    }
}
