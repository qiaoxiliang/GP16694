package com.prototype.deepClone;

import java.util.ArrayList;
import java.util.List;

public class DeepCloneTest {

    public static void main(String[] args) {
        DeepClone source = new DeepClone();

        List actions = new ArrayList();
        actions.add("get方法");
        actions.add("set方法");
        actions.add("构造方法");

        source.setType("Prototype");
        source.setCount(1);
        source.setActinos(actions);

        DeepClone target = source.deepClone();

        System.out.println(source.getActinos() == target.getActinos());

    }

}
