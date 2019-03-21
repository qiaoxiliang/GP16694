package template.abstractTemplate;

public class AbstractTemplateTest {

    public static void main(String[] args) {
        FileParam fileParam = new FileParam();
        fileParam.setAddr("192.168.25.30");
        fileParam.setPort("2333");
        fileParam.setFileName("E:\\xftpPath\\test.data");
        fileParam.setMailAddr("163@163.com");

        EfinanceDataUpload upload = new EfinanceDataUpload();

        upload.setFileParam(fileParam);
        upload.fileUpload();
    }
}
