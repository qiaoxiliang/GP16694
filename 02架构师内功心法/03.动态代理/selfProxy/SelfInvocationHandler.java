package selfProxy;

import java.lang.reflect.Method;

public interface SelfInvocationHandler {

    /**
     * a
     * @param proxy  代理对象本身
     * @param method 要调用的方法
     * @param args   方法调用需要的使用到的参数
     * @return
     */
    Object invoke(Object proxy, Method method,Object[] args);
}
