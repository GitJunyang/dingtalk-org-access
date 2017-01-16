package dingtalk.org.access.vo;
import java.io.Serializable;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class EmpSimpileVO implements Serializable{
    private String name;
    private String userid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "EmpSimpileVO{" +
                "name='" + name + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}