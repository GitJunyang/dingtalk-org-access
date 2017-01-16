package dingtalk.org.access.util;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public enum ErrorCode {
    SUCCESS("0","success"),
    SYS_ERROR("-1","系统繁忙");

    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    private ErrorCode(String errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
