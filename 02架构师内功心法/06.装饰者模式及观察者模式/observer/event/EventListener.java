package observer.event;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class EventListener {

    private Map<String,Event> eventMap = new HashMap<String,Event>();


    // 将事件添加到监听器中
    public void addListener(Event event){

        eventMap.put(event.getName(),event);

    }

    // 事件名称
    public void trigger(String eventName, Action action) throws InvocationTargetException, IllegalAccessException {

        // 获取保存在监听中的时间
        Event event = eventMap.get(eventName);

        if(event == null){
            System.out.println("该事件没有被监听");
        }

        //根据要触发的事件名称，从时间动作中将该事件找出
        // 当要通过反射执行一个具体的方法的时候，需要传入method所在类的实例和method使用的方法参数
        event.getCallBackAction().invoke(action,null);
    }
}
