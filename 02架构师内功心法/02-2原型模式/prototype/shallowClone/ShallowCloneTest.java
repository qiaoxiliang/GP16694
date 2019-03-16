package com.prototype.shallowClone;

import java.util.ArrayList;
import java.util.List;

public class ShallowCloneTest {

    public static void main(String[] args) {
        ShallowClone source = new ShallowClone();
        List actions = new ArrayList();
        actions.add("get方法");
        actions.add("set方法");
        actions.add("构造方法");

        source.setType("Prototype");
        source.setCount(1);
        source.setActinos(actions);

        ShallowClone target = new ShallowClone();
        target = source.shallowClone();

        // 比较source和target对象中，引用类型的值是否相同
        System.out.println(source.getActinos() == target.getActinos());
    }
}
