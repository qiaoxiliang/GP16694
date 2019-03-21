package template.callBackTemplate;



import java.util.List;

public class CallBackTemplateTest {

    public static void main(String[] args) {
        FileParam fileParam = new FileParam();
        fileParam.setAddr("192.168.25.29");
        fileParam.setPort("2333");
        fileParam.setFileName("E:\\xftpPath\\test.data");
        fileParam.setMailAddr("163@163.com");

        FlieUpLoadTemplate FlieUpLoadTemplate = new FlieUpLoadTemplate();

        FlieUpLoadTemplate.setFileParam(fileParam);

        EfinanceDataUpload upload = new EfinanceDataUpload();


        FlieUpLoadTemplate.fileUpload(new UploadCallBack() {
            @Override
            public List<String> getRowList() {
                upload.getRowList();
                return null;
            }

            @Override
            public boolean needSendMail(boolean flg) {

                return upload.needSendMail(true);
            }
        });

    }
}
