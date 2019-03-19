package jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicIntermediaryProxy implements InvocationHandler{

    private Intermediary intermediary;

    public Intermediary getInstance(Intermediary intermediary){

            this.intermediary = intermediary;

            // classLoader：类加载器，使用当前类的或者使用接口类的都可以
            // Class<?>[] interfaces：必须使用接口类的，jdk生成Proxy类的时候，需要通过 接口寻找方法
            // InvocationHandler h: 必须传一个实现了InvocationHandler接口的类
            return (Intermediary) Proxy.newProxyInstance(this.getClass().getClassLoader(),intermediary.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy     ：jdk自己生成Proxy类使用
     * @param method    ：调用接口类中的方法
     * @param args      ：接口类中的方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        System.out.println(proxy.getClass().getName());
        Object object = method.invoke(this.intermediary,args);
        after();
        return object;
    }

    private void after() {

        System.out.println("后置处理");
    }

    private void before() {

        System.out.println("前置处理");
    }
}
