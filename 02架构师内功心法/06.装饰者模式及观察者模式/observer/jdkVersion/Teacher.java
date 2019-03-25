package observer.jdkVersion;

import java.util.Observable;
import java.util.Observer;

// 观察者要实现Observer接口
// 当被观察者的动作发生变化时，会通知观察者
public class Teacher implements Observer{

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     *
     * @param observable 继承了GPerComunity的类，即被观察者的类
     * @param arg  被观察者中调用notifyObservers方法中传入的参数
     */
    @Override
    public void update(Observable observable, Object arg) {

        GPerComunity gPerComunity = (GPerComunity)observable;
        Question question = (Question)arg;

        System.out.println(name +
                "老师您好，您收到了来自论坛"
                + gPerComunity.getName()
                + "，" +
                question.getName() + "的问题，问题内容是："
                + question.getProblem());

    }
}
