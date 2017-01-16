package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.service.OrgDeptService;
import dingtalk.org.access.service.OrgEmpService;
import dingtalk.org.access.service.impl.OrgEmpServiceImpl;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;
import dingtalk.org.access.vo.EmpSimpileVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgEmpServiceTest extends BaseTestCase {
    @Resource
    private OrgEmpService orgEmpService;
    @Test
    public void test_getOrgDeptList(){
        ServiceResult<List<EmpSimpileVO>> serviceResult = orgEmpService.getOrgEmpList(640171L);
        System.err.println(JSON.toJSONString(serviceResult));
    }



    @Test
    public void test_createEmp(){
        OrgEmpServiceImpl.CreateEmpVO createEmpVO = new OrgEmpServiceImpl.CreateEmpVO();
        createEmpVO.setUserid("010001");
        createEmpVO.setName("张三");
        createEmpVO.setDepartment(Arrays.asList(1,27289328));
        //createEmpVO.setOrderInDepts();
        createEmpVO.setPosition("产品经理");
        createEmpVO.setMobile("18633582327");
        createEmpVO.setTel("010-123333");
        createEmpVO.setWorkPlace("setWorkPlace");
        createEmpVO.setRemark("setRemark");
        createEmpVO.setEmail("xxx@alibaba-inc.com");
        createEmpVO.setJobnumber("GH-010001");
        createEmpVO.setIsHide(Boolean.FALSE);
        createEmpVO.setIsSenior(Boolean.FALSE);
        JSONObject extaJson = new JSONObject();
        extaJson.put("爱好","旅游");
        extaJson.put("年龄","24");
        createEmpVO.setExtattr(extaJson);
        ServiceResult<String> serviceResult = orgEmpService.createEmp(createEmpVO);
        System.err.println(JSON.toJSONString(serviceResult));
    }



}
