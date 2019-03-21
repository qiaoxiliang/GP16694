package template.abstractTemplate;

import java.util.List;

public class EfinanceDataUpload extends FlieUpLoadTemplate{


    @Override
    protected boolean needSendMail(boolean flg) {
        return true;
    }

    @Override
    protected List<String> getRowList() {
        System.out.println("通过数据库获取业务数据");
        return null;
    }
}
