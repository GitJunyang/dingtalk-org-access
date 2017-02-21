package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/21 上午10:04
 */
public class OrgMessageResultVO {
    private int errcode;
    private String errsg;
    private String invaliduser;
    private String invalidparty;
    private String forbiddenUserId;
    private String messageId;

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

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }

    public String getForbiddenUserId() {
        return forbiddenUserId;
    }

    public void setForbiddenUserId(String forbiddenUserId) {
        this.forbiddenUserId = forbiddenUserId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "OrgMessageResultVO{" +
                "errcode=" + errcode +
                ", errsg='" + errsg + '\'' +
                ", invaliduser='" + invaliduser + '\'' +
                ", invalidparty='" + invalidparty + '\'' +
                ", forbiddenUserId='" + forbiddenUserId + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
