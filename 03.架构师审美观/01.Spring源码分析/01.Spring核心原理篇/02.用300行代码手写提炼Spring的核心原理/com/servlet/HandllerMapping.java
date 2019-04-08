package com.servlet;

import com.gp16694.annotation.GP16694RequestMapping;
import com.gp16694.annotation.GP16694RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandllerMapping {

    private String url;
    private Method method;
    private Object controller;
    //用来保存方法参数类型对应的名称和位置
    private Map<String,Integer> paramTypeIndexMapping;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public boolean matchUrl(String url){

        return this.url.equals(url);

    }

    public Map<String, Integer> getParamTypeIndexMapping() {
        return paramTypeIndexMapping;
    }

    public void setParamTypeIndexMapping() {

        paramTypeIndexMapping = new HashMap<String, Integer>();

        Class<?>[] classes = this.method.getParameterTypes();

        // 如果方法参数中含有HTTPServletRequest或者HTTPServletResponse，将这两个参数的位置放入到map中
        for(int i = 0 ; i < classes.length; i++){

            Class clazz = classes[i];
            // 使用同一个类加载器加载的class可以使用==或equals进行比较
            if(clazz == HttpServletRequest.class || clazz == HttpServletResponse.class){
                paramTypeIndexMapping.put(clazz.getTypeName(),i);
            }
        }

        // 获取参数列表中的参数，以及每个参数对应的注解
        // 第一个维度对应参数列表中的参数，第二个维度对应参数的注解
        Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();


        for(int i = 0; i < parameterAnnotations.length; i++){

            Annotation[]  paramAnnotations = parameterAnnotations[i];

            for (Annotation paramAnnotation :paramAnnotations) {

                // 如果参数被GP16694RequestParam标注
                if(paramAnnotation instanceof GP16694RequestParam){

                    // 将GP16694RequestParam上标注的名称和位置保存进来
                    GP16694RequestParam gp16694RequestParam = (GP16694RequestParam)paramAnnotation;
                    paramTypeIndexMapping.put(gp16694RequestParam.value(),i);
                }
            }

        }

    }
}
