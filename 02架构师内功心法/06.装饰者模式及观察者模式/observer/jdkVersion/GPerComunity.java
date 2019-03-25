package observer.jdkVersion;


import java.util.Observable;

// 继承【Observable】这个类的为被观察者，一旦这个类中的动作有什么变化，
// 就将变化通知给观察者
public class GPerComunity extends Observable {

    private String name;

    public GPerComunity(String name) {
        this.name = name;
    }

    public void publish(Question question){

        System.out.println(question.getName() + "在论坛发布了问题" + question.getProblem());

        this.setChanged();
        this.notifyObservers(question);

    }

    public String getName() {
        return name;
    }
}
