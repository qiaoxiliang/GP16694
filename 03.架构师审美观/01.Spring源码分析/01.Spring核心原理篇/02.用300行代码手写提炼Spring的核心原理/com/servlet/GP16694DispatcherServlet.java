package com.servlet;



import com.gp16694.annotation.GP16694AutoWired;
import com.gp16694.annotation.GP16694Controller;
import com.gp16694.annotation.GP16694RequestMapping;
import com.gp16694.annotation.GP16694Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;


public class GP16694DispatcherServlet extends HttpServlet{

    /**
     * 保存配置文件
     */
    private static Properties properties = new Properties();

    /**
     * init-param
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private static String INIT_PARAM_NAME = "contextConfigLocation";

    /**
     * 用来保存对象包下的所有的类的全路径com.xxx.xxx.Xxxx
     */
    private static List<String> CLASS_NAMES = new ArrayList<String>();

    /**
     * 用来存储被GPController和GP16694Service修饰的java类
     */
    private static Map<String,Object> IOC = new HashMap<String,Object>();

    /**
     * 存放HandlerMapping的容器
     */
    private static List<HandllerMapping> handllerMappings = new ArrayList<HandllerMapping>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doDispatch(req,resp);
    }

    /**
     *  获取用户在地址栏输入的地址，并根据地址来找到对应的方法并执行
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        // 获取相对地址，即刨除地址头加端口号之外的地址
        // 例如http://localhost:8080/spring//testUrl的相对地址为/spring//testUrl
        String requestURI = req.getRequestURI();
        //如果地址栏中存在复数的/,将其统一修改为一个/
        requestURI = requestURI.replaceAll("/+","/");

        // 获取当前容器的路径，即打包的项目的名称
        // 将项目的路径去掉后，得到用户输入的真实路径
        // 例/spring//testUrl中的/spring
        requestURI = requestURI.replaceAll(req.getContextPath(),"");
        // 根据用户的路径去查找有没有该路径对应的方法
        HandllerMapping handllerMapping = getHandllerMapping(requestURI);

        // 如果handllermapping中不存在地址对应的方法，提示404
        if(handllerMapping == null){
            try {
                resp.getWriter().println("404 url Not Found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 获取到对应的handlerMapping之后，要反射handlerMaping中的method，进行逻辑处理
        Method tagetMethod = handllerMapping.getMethod();

        // 根据handlerMapping中保存的beanName在IOC容器中获取对应的实例
        try {

            Object[] objects = new Object[handllerMapping.getParamTypeIndexMapping().size()];

            Map<String, Integer> paramTypeIndexMapping = handllerMapping.getParamTypeIndexMapping();

            // 如果方法参数中含有HTTPServletRequest将HttpServletRequest放入参数数组中
            if(paramTypeIndexMapping.containsKey(HttpServletRequest.class.getName())){

                 objects[paramTypeIndexMapping.get(HttpServletRequest.class.getName())] = req;
            }

            // 如果方法参数中含有HttpServletResponse放入参数数组中
            if(paramTypeIndexMapping.containsKey(HttpServletResponse.class.getName())){

                objects[paramTypeIndexMapping.get(HttpServletResponse.class.getName())] = resp;
            }

            // 循环获取请求参数
            for (Map.Entry entry : req.getParameterMap().entrySet()) {

                // 请求参数的名称是Gp16694RequestParam标注的值
                if(paramTypeIndexMapping.containsKey(entry.getKey())){

                    String[] strs = (String[]) entry.getValue();

                    String reqvalue =  org.apache.commons.lang3.StringUtils.join(strs,",");
                    objects[paramTypeIndexMapping.get(entry.getKey())] = reqvalue;
                }
            }

            Object returnValue = tagetMethod.invoke(handllerMapping.getController(),objects  );
            if(returnValue == null || returnValue instanceof  Void) return;

            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write(returnValue.toString());
        }  catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询是否有方法可以接受用户传输过来的url
     * @param requestURI
     * @return
     */
    private HandllerMapping getHandllerMapping(String requestURI) {

        for (HandllerMapping handllerMapping : handllerMappings) {

            if(handllerMapping.matchUrl(requestURI)){

                return handllerMapping;
            }
        }

        return null;

    }

    /**
     * config中保存的是web.xml中填写的内容
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        // 加载配置文件
        doLoadConfig(config);
        System.out.println("++++++++++++++++++++++++++config loading is complete");

        // 扫描目标包下所有的类，并将其保存起来
        doScanner((String) properties.get("source"));
        System.out.println("++++++++++++++++++++++++++package Scanner is complete");

        // 将具有Controller和Service
        doInstanceIOC();
        System.out.println("++++++++++++++++++++++++++IOC Instance is complete");

        // 依赖注入操作
        doAutoWired();
        System.out.println("++++++++++++++++++++++++++Instance AutoWired is complete");

        // 初始化RequestMapping中的地址，与controller中的方法的对应关系
        doInstanceHandllerMapping();
        System.out.println("++++++++++++++++++++++++++GP16694 INIT is complete");
    }


    /**
     * 1.加载配置文件
     * @param config
     */
    private void doLoadConfig(ServletConfig config) {

        // 通过该方法可以获取到<init-param>中配置的内容
        String configFIleName = config.getInitParameter(INIT_PARAM_NAME);

        // 将配置文件作为流读入进来
        //InputStream in = this.getClass().getClassLoader().getSystemResourceAsStream("/" + configFIleName);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(configFIleName);
        System.out.println();

        try {
            // 使用Properties类将输入流转化为Properties对象
            properties.load(in);
            System.out.println("+++++++++++++++++++++++++++++++++++++");
            // 获取需要扫描的包路径
            System.out.println(properties.get("source"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据配置文件中配置的目标包的路径，扫描这个包下所有的类
     * ，并将这些类保存起来
     * @param  path 为了可以继续的递归调用该方法，所以将路径作为参数传输
     */
    private void doScanner(String path) {

        // 获取当前路径
        URL url = this.getClass().getClassLoader().getResource("/" + path.replaceAll("\\.","/"));

        // 获取这个
        File fileList = new File(url.getFile());

        for (File file: fileList.listFiles()) {

            // 如果是文件夹，继续扫描
            if(file.isDirectory()){
                doScanner(path + "." + file.getName());
            }else{
                // 如果不是路径，将该将类保存在list中
                CLASS_NAMES.add(path + "." + file.getName().replaceAll(".class",""));
            }
        }
    }

    /**
     * 将目标包下具有GP16694Controller
     * 和GP16694Service注解的类存入到IOC容器中
     */
    private void doInstanceIOC() {
        //如果包下没有含有 @GP1669Conroller和@GP16694Service注解的类，直接跳过
        if(CLASS_NAMES.isEmpty())return;

        for (String clazzName:CLASS_NAMES) {

            try {
                Class<?> clazz = Class.forName(clazzName);

                // 如果该类是被GP16694Controller或者GP16694Service标注的类
                if(clazz.isAnnotationPresent(GP16694Controller.class)
                        || clazz.isAnnotationPresent(GP16694Service.class)){

                    // 将class类名的首字母小写存储到IOC容器中
                    String className = clazz.getSimpleName();
                    IOC.put(lowerFirstChar(className),clazz.newInstance());

                }

                // 如果Service有单独命名的话
                // 将单独命名的Service再保存一份到IOC容器中
                GP16694Service gp16694Service =clazz.getAnnotation(GP16694Service.class);
                if(gp16694Service != null && !"".equals(gp16694Service.value()))
                IOC.put(gp16694Service.value(),clazz.newInstance());


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private String lowerFirstChar(String className) {

        char [] chars = className.toCharArray();

        chars[0] += 32;

        return String.valueOf(chars);
    }

    /**
     * 依赖注入操作
     * 从IOC容器中获取标注了 @GP16694Controller或@16694Service的类，看他们是否有哪些属性标注了
     * @1GP6694Autowired如果有，为该属性赋值
     */
    private void doAutoWired() {

        // 如果IOC容器中没有数据，直接返回
        if(IOC.isEmpty())return;

        for (Map.Entry<String, Object> entry : IOC.entrySet()) {

            // 获取IOC容器中保存的，所有目标类的实例，并获取所有定义的对象
            for (Field field : entry.getValue().getClass().getDeclaredFields()) {


                // 如果当前的属性被@GP16694AtutoWired修饰的话
                if(field.isAnnotationPresent(GP16694AutoWired.class)){

                    try {
                        // 使用此方法可以强制访问私用的变量
                        field.setAccessible(true);
                        // 根据属性的名字去，IOC容器中获取对应的实例
                        field.set(entry.getValue(),IOC.get(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }

    /**
     * 初始化@GPRequestMapping注解中标注的地址与GP16694Controller中方法的对应关系
     */
    private void doInstanceHandllerMapping() {

        for (Map.Entry<String, Object> entry : IOC.entrySet()) {

            // 由于@GP1669RequestMapping只标注在GP16694Controllers上
            // 为了减少循环次数，此处先判断IOC容器中存放的实体是不是被GP16694Controller
            // 标注的类
            if(entry.getValue().getClass().isAnnotationPresent(GP16694Controller.class)){

                // 先看一下类上有没有标注GPRequestMapping注解
                // 如果有的话，将类上注解的地址获取到，作为这个类的base路径
                Class controllerClass = entry.getValue().getClass();
                GP16694RequestMapping gp16694RequestMapping = (GP16694RequestMapping) controllerClass.getAnnotation(GP16694RequestMapping.class);
                String baseUrl = "/";
                // 如果类上有注解@RequestMapping，则将类上注解中的值作为这个类的baseUrl
                // 否则将baseUrl设为"/"
                if(gp16694RequestMapping != null){
                    baseUrl = gp16694RequestMapping.value();
                }

                // 循环这个类中的所有public方法，获取有标注有@GP16694RequestMapping的方法
                for (Method method : controllerClass.getMethods()) {

                    HandllerMapping handllerMappinp = new HandllerMapping();

                    // 判断当前method上是否有标注@GP16694RequestMapping
                    if(method.isAnnotationPresent(GP16694RequestMapping.class)){

                        GP16694RequestMapping gp16694RequestMapping1 = (GP16694RequestMapping)method.getAnnotation(GP16694RequestMapping.class);

                        // 将Controller的实例放进去
                        handllerMappinp.setController(entry.getValue());
                        // 将标注有GP16694RequestMapping的方法存入进去
                        handllerMappinp.setMethod(method);
                        // 将路径存入进去
                        handllerMappinp.setUrl(baseUrl + gp16694RequestMapping1.value());
                        // 设置参数列表对应关系
                        handllerMappinp.setParamTypeIndexMapping();
                        // 将此HandlerMapping放入到容器中
                        handllerMappings.add(handllerMappinp);
                    }


                }

            }

        }

    }
}


