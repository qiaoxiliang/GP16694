package observer.guavaVersion;

import com.google.common.eventbus.Subscribe;

public class Teacher{

    private String name;

    public Teacher(String name) {
        this.name = name;
    }


    // 在使用guava的时候，实现了这个注解的类是观察者
    @Subscribe
    public void receive(Object arg) {

        Question question = (Question)arg;

        System.out.println(name +
                "老师您好，您收到了来自论坛"
                + "，" +
                question.getName() + "的问题，问题内容是："
                + question.getProblem());

    }
}
