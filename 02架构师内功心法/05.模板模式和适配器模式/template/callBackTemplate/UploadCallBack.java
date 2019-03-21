package template.callBackTemplate;

import java.util.List;

public interface UploadCallBack {

    List<String> getRowList();

    boolean needSendMail(boolean flg);
}
