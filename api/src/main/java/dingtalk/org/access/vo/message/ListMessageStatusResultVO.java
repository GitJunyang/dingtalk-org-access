package dingtalk.org.access.vo.message;

import java.util.List;

/**
 * @author zhaoting.yht
 * @version $Id$
 * @since 17/2/21 上午10:16
 */
public class ListMessageStatusResultVO {
    private int errcode;
    private String errsg;
    private List<String> read;
    private List<String> unread;

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

    public List<String> getRead() {
        return read;
    }

    public void setRead(List<String> read) {
        this.read = read;
    }

    public List<String> getUnread() {
        return unread;
    }

    public void setUnread(List<String> unread) {
        this.unread = unread;
    }
}
