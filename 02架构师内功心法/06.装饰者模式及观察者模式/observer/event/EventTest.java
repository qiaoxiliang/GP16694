package observer.event;

import java.lang.reflect.InvocationTargetException;

public class EventTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Mouse action = new Mouse();

        Event mouseEvent = new Event(MouseEventName.ON_CLICK,action);

        EventListener listener = new EventListener();

        listener.addListener(mouseEvent);
        listener.trigger(mouseEvent.getName(),action);
    }
}
