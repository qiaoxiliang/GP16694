package adapter.newSource.factory;

import adapter.newSource.MoblieLoginAdapter;
import adapter.newSource.SinaLoginAdapter;
import adapter.newSource.WechatLoginAdapter;
import adapter.newSource.adapter.LoginAdapter;

import java.util.HashMap;
import java.util.Map;

public class LoginFactory {

    private LoginFactory(){

    }

    private static Map<String ,LoginAdapter> adapterMap = new HashMap<String ,LoginAdapter>();

    public static String WE_CHAT = "WH_CHAT";
    public static String SINA = "SINA";
    public static String MOBILE = "MOBILE";

   static {

       adapterMap.put(WE_CHAT,new WechatLoginAdapter());
       adapterMap.put(SINA,new SinaLoginAdapter());
       adapterMap.put(MOBILE,new MoblieLoginAdapter());
   }

   public static  LoginAdapter getInstance(String type){

       return adapterMap.get(type);

   }
}
