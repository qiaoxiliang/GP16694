package selfProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 参照jdk的动态代理，自己手写的动态代理
 */
// 1.要实现动态代理类
public class SelfDynamicProxy implements SelfInvocationHandler{

    private Intermediary target;

    public Intermediary getInstance(Intermediary intermediary){

        this.target = intermediary;

        return (Intermediary)SelfProxy.newProxyInstance(new SelfClassLoader(),target.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        before();
        Object o = null;
        try {
            o = method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        after();

        return o;
    }

    private void after() {

        System.out.println("后置处理");
    }

    private void before() {

        System.out.println("前置处理");
    }
}
