package dingtalk.org.access.service;

import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;
import dingtalk.org.access.vo.EmpSimpileVO;

import java.util.List;
import java.util.Map;

/**
 * 企业人员相关服务
 * Created by lifeng.zlf on 2017/1/12.
 */
public interface OrgEmpService {
    /**
     * 获取员工列表
     * @param deptId
     * @return
     */
    public ServiceResult<List<EmpSimpileVO>> getOrgEmpList(Long deptId);

    /**
     * 创建一个用户
     * @param createEmpVO
     * @return
     */
    public ServiceResult<String> createEmp(OrgEmpService.CreateEmpVO createEmpVO);



    /**
     * 创建员工VO
     * 因为这个VO只在创建员工这个接口中使用,所以定义成了内部类
     */
    public static class CreateEmpVO{
        private String userid;
        private String name;
        private Map<Integer,Integer> orderInDepts;
        private List<Integer> department;
        private String position;
        private String mobile;
        private String tel;
        private String workPlace;
        private String remark;
        private String email;
        private String jobnumber;
        private Boolean isHide;
        private Boolean isSenior;
        private JSONObject extattr;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<Integer, Integer> getOrderInDepts() {
            return orderInDepts;
        }

        public void setOrderInDepts(Map<Integer, Integer> orderInDepts) {
            this.orderInDepts = orderInDepts;
        }

        public List<Integer> getDepartment() {
            return department;
        }

        public void setDepartment(List<Integer> department) {
            this.department = department;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getWorkPlace() {
            return workPlace;
        }

        public void setWorkPlace(String workPlace) {
            this.workPlace = workPlace;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getJobnumber() {
            return jobnumber;
        }

        public void setJobnumber(String jobnumber) {
            this.jobnumber = jobnumber;
        }

        public Boolean getIsHide() {
            return isHide;
        }

        public void setIsHide(Boolean isHide) {
            this.isHide = isHide;
        }

        public Boolean getIsSenior() {
            return isSenior;
        }

        public void setIsSenior(Boolean isSenior) {
            this.isSenior = isSenior;
        }

        public JSONObject getExtattr() {
            return extattr;
        }

        public void setExtattr(JSONObject extattr) {
            this.extattr = extattr;
        }
    }

}
