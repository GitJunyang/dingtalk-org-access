package dingtalk.org.access.vo;
import java.io.Serializable;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class DeptSimpileVO implements Serializable{
    private Long id;
    private Boolean createDeptGroup;
    private String name;
    private Boolean autoAddUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    @Override
    public String
    toString() {
        return "DeptSimpileVO{" +
                "id=" + id +
                ", createDeptGroup=" + createDeptGroup +
                ", name='" + name + '\'' +
                ", autoAddUser=" + autoAddUser +
                '}';
    }
}