package observer.jdkVersion;

public class jdkVersionTest {

    public static void main(String[] args) {
        Question question = new Question();
        question.setName("小乔");
        question.setProblem("socket属于一种观察者模式吗");

        GPerComunity gPerComunity = new GPerComunity("咕泡社区");

        // 设置需要通知的观察者
        Teacher teacher = new Teacher("Tom");
        gPerComunity.addObserver(teacher);
        // 需要先设置要通知的观察者之后再执行被观察者的事件
        gPerComunity.publish(question);

    }
}
