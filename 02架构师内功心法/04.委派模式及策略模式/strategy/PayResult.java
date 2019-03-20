package strategy;

public class PayResult {

    private String code;
    private String msg;
    private String payMethodName;

    @Override
    public String toString() {
        return "支付结果 {" +
                "支付状态码：'" + code + '\'' +
                ", 支付信息：'" + msg + '\'' +
                ", 使用的支付方式'" + payMethodName + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String payMethodName) {
        this.payMethodName = payMethodName;
    }
}
