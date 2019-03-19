package selfProxy;
import java.lang.reflect.*;
public class $Proxy0 implements Intermediary{
    private SelfInvocationHandler h;

    public $Proxy0(SelfInvocationHandler h){
        this.h = h;
    }
    public String forBuyer () {
        Object o = null; Method m = null;
        try{
        m = Intermediary.class.getMethod("forBuyer",new Class[]{});
        o =  this.h.invoke(this,m,null);
        }catch(NoSuchMethodException e){
        e.printStackTrace();}
        return (String)o;
    }
    public void forSeller () {
        Method m = null;
        try{
        m = Intermediary.class.getMethod("forSeller",new Class[]{});
        this.h.invoke(this,m,null);
        }catch(NoSuchMethodException e){
        e.printStackTrace();
        }
    }
}
