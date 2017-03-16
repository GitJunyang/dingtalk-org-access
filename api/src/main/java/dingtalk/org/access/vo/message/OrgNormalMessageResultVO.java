package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/21 上午10:04
 */
public class OrgNormalMessageResultVO {
    private int errcode;
    private String errsg;
    private String receiver;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrsg() {
        return errsg;
    }

    public void setErrsg(String errsg) {
        this.errsg = errsg;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "OrgNormalMessageResultVO{" +
                "errcode=" + errcode +
                ", errsg='" + errsg + '\'' +
                ", receiver='" + receiver + '\'' +
                '}';
    }
}
