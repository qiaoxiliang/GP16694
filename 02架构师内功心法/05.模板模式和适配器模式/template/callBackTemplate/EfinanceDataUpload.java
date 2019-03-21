package template.callBackTemplate;

import template.abstractTemplate.FlieUpLoadTemplate;

import java.util.List;

public class EfinanceDataUpload{


    protected boolean needSendMail(boolean flg) {
        return true;
    }

    protected List<String> getRowList() {
        System.out.println("通过数据库获取业务数据");
        return null;
    }
}
