package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/21 上午10:04
 */
public class ChannelMessageResultVO {
    private int errcode;
    private String errsg;
    private String invaliduser;
    private String forbiddenUserId;
    private String taskid;

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

    public String getForbiddenUserId() {
        return forbiddenUserId;
    }

    public void setForbiddenUserId(String forbiddenUserId) {
        this.forbiddenUserId = forbiddenUserId;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
}
