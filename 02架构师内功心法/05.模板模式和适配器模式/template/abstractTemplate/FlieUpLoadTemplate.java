package template.abstractTemplate;

import java.io.*;
import java.nio.channels.Channel;
import java.util.List;

public abstract class FlieUpLoadTemplate {

    private FileParam fileParam;

    public FileParam getFileParam() {
        return fileParam;
    }

    public void setFileParam(FileParam fileParam) {
        this.fileParam = fileParam;
    }

    public final int fileUpload(){

        try {
            // 数据文件输出流
            FileOutputStream datafop = null;

            // 数据文件输出流用于进行文件格式输出
            OutputStreamWriter dataOsw = null;

            // 获取上传所需要的各种参数
            FileParam fileParam = getFileParam();

            // 连接上传服务器
            Channel channel = connectServer(fileParam);

            List<String> rowList = getRowList();

            // 根据传输的数据生成文件
            File file = openStream(datafop,dataOsw,fileParam,rowList);

            // 上传文件
            upload(channel,file);

            // 是否需要发送邮件
            if(needSendMail(false)){

                sendMail(fileParam);
            }

        }catch (Exception e){

            e.printStackTrace();

        }
       return 1;
    }

    private final void sendMail(FileParam fileParam) {

        System.out.println("已将邮件发送至:" + fileParam.getMailAddr() + "邮箱");
    }

    protected boolean needSendMail(boolean flg) {

        return flg;

    }

    private void upload(Channel channel, File file) {

        System.out.println("上传文件");
    }

    protected abstract List<String> getRowList();

    private final File openStream(FileOutputStream datafop, OutputStreamWriter dataOsw,FileParam fileParam,List<String> rowList) throws Exception {

        File file = new File(fileParam.getFileName());

        datafop = new FileOutputStream(file);
        dataOsw = new OutputStreamWriter(datafop);

        System.out.println("生成文件，文件名为" + file.getPath() + "/" +   file.getName());

        return file;

    }

    protected final Channel connectServer(FileParam fileParam){

        System.out.println("上传服务器地址为：" +  fileParam.getAddr());
        System.out.println("上传服务器端口为：" +  fileParam.getPort());

        return  null;
    }

}
