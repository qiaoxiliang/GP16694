package observer.guavaVersion;


import com.google.common.eventbus.EventBus;

public class GPerComunity {


    public static void main(String[] args) {
        Question question = new Question();
        question.setName("小乔");
        question.setProblem("socket属于一种观察者模式吗");
        question.setComunityName("咕泡论坛 ");

        // guava的事件总线，用来注册观察者和处理观察者模式相关的内容
        EventBus eventBus = new EventBus();

        Teacher teacher = new Teacher("Tom");
        eventBus.register(teacher);
        eventBus.post(question);
    }

}
