package observer.event;



public class Mouse implements Action{

    public void onClick(){

        System.out.println("单击鼠标");
    }

    public void wheel(Event event){

        System.out.println("滚动鼠标");
    }
}
