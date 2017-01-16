package dingtalk.org.access.service;

import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;

import java.util.List;
import java.util.Map;

/**
 * 企业部门相关服务
 * Created by lifeng.zlf on 2017/1/12.
 */
public interface OrgDeptService {
    /**
     * 获取企业制定部门下的子部门
     *
     * @return
     */
    public ServiceResult<List<DeptSimpileVO>> getOrgDeptList(Long deptId);


    /**
     * 创建一个部门
     *
     * @param createDeptVO
     * @return
     */
    public ServiceResult<Long> createDept(CreateDeptVO createDeptVO);


    /**
     * 创建员工VO
     * 因为这个VO只在创建员工这个接口中使用,所以定义成了内部类
     */
    public static class CreateDeptVO {
        private String name;
        private Long parentid;
        private Integer order;
        private Boolean createDeptGroup;
        private Boolean deptHiding;
        private String deptPerimits;
        private String userPerimits;
        private Boolean outerDept;
        private String outerPermitDepts;
        private String outerPermitUsers;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getParentid() {
            return parentid;
        }

        public void setParentid(Long parentid) {
            this.parentid = parentid;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public Boolean getCreateDeptGroup() {
            return createDeptGroup;
        }

        public void setCreateDeptGroup(Boolean createDeptGroup) {
            this.createDeptGroup = createDeptGroup;
        }

        public Boolean getDeptHiding() {
            return deptHiding;
        }

        public void setDeptHiding(Boolean deptHiding) {
            this.deptHiding = deptHiding;
        }

        public String getDeptPerimits() {
            return deptPerimits;
        }

        public void setDeptPerimits(String deptPerimits) {
            this.deptPerimits = deptPerimits;
        }

        public String getUserPerimits() {
            return userPerimits;
        }

        public void setUserPerimits(String userPerimits) {
            this.userPerimits = userPerimits;
        }

        public Boolean getOuterDept() {
            return outerDept;
        }

        public void setOuterDept(Boolean outerDept) {
            this.outerDept = outerDept;
        }

        public String getOuterPermitDepts() {
            return outerPermitDepts;
        }

        public void setOuterPermitDepts(String outerPermitDepts) {
            this.outerPermitDepts = outerPermitDepts;
        }

        public String getOuterPermitUsers() {
            return outerPermitUsers;
        }

        public void setOuterPermitUsers(String outerPermitUsers) {
            this.outerPermitUsers = outerPermitUsers;
        }
    }
}