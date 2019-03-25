package observer.event;

import java.lang.reflect.Method;

public class Event {

    private String name;
    private Method callBackAction;

    public Event(String name, Object callBackAction) {
        this.name = name;

        if(callBackAction != null){
            try {
                Method method = callBackAction.getClass().getMethod(name,null);
                this.callBackAction = method;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }

    public String getName() {
        return name;
    }

    public Method getCallBackAction() {
        return callBackAction;
    }
}
