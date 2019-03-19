package selfProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *  在次方法中，jdk自动生成了$Proxy0代理类，并将该类编译成Class文件
 */
public class SelfProxy {

    private static String LN = "\r\n";

    //生成$Proxy类并将其编译成class文件
    public static Object newProxyInstance(SelfClassLoader selfClassLoader, Class<?>[] interfaces, SelfDynamicProxy selfDynamicProxy) {

        try {
            // 1.创建Java类$Proxy0
            String src = generateProxySrc(interfaces, selfDynamicProxy);

            // 2.将生成好的文件编译为class
            String filePath = SelfDynamicProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 3.使用classLoader加载编译好的$Proxy0对象
            Class proxyClass = selfClassLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(SelfInvocationHandler.class);

            return c.newInstance(selfDynamicProxy);
        }catch (Exception e){

            e.printStackTrace();
        }
        // 3.通过classLoader加载


        return null;
    }

    private static String generateProxySrc(Class<?>[] interfaces, SelfDynamicProxy selfDynamicProxy) throws NoSuchMethodException {

        StringBuffer sb = new StringBuffer();

        // 循环拼接接口名称
        String intefaceName = "";
        for (Class<?> inteface: interfaces) {

            intefaceName = inteface.getSimpleName() + ",";
        }

        // 将最后一位的，截取掉
        intefaceName = intefaceName.substring(0,intefaceName.length() - 1);


        sb.append("package selfProxy;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        sb.append("public class $Proxy0 implements " + intefaceName + "{" + LN);
        sb.append("private SelfInvocationHandler h;" + LN);
        sb.append("public $Proxy0(SelfInvocationHandler h){ " + LN);
        sb.append("this.h = h;" + LN);
        sb.append("}" + LN);

        for (Class<?> inteface: interfaces) {

            for (Method method:inteface.getMethods()) {

                sb.append("public " + method.getReturnType().getName() + " " + method.getName() + " () {" + LN);

                    if(!"void".equals(method.getReturnType().getName())){
                        sb.append("Object o = null;");
                    }

                    sb.append(" Method m = null; " + LN);

                    sb.append("try{" + LN);

                    sb.append("m = " + inteface.getName() + ".class.getMethod(\"" + method.getName() + "\"" + ",new Class[]{});" + LN);

                if(!"void".equals(method.getReturnType().getName())){
                    sb.append("o =  this.h.invoke(this,m,null);" + LN);
                }else {
                    sb.append("this.h.invoke(this,m,null);" + LN);
                }

                    sb.append("}catch(NoSuchMethodException e){" + LN);
                    sb.append("e.printStackTrace();}" + LN);

                if(!"void".equals(method.getReturnType().getName())){
                    sb.append("return " + "(" + method.getReturnType().getName() +   ")o;" + LN);
                }

                   sb.append(" } " + LN);
            }

        }


        sb.append("}" + LN);

        return sb.toString();

    }
}
