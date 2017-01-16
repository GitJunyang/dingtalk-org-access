package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.OrgDeptService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.DeptSimpileVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgDeptServiceTest extends BaseTestCase {
    @Resource
    private OrgDeptService orgDeptService;
    @Test
    public void test_getOrgDeptList(){
        ServiceResult<List<DeptSimpileVO>> serviceResult = orgDeptService.getOrgDeptList(null);
        System.err.println(JSON.toJSONString(serviceResult));
    }


    @Test
    public void test_get_createDept(){
        OrgDeptService.CreateDeptVO createDeptVO = new OrgDeptService.CreateDeptVO();
        createDeptVO.setParentid(1L);
        createDeptVO.setName("钉钉事业部A");
        createDeptVO.setOrder(1);
        createDeptVO.setCreateDeptGroup(Boolean.TRUE);
        ServiceResult<Long> serviceResult = orgDeptService.createDept(createDeptVO);
        System.err.println(JSON.toJSONString(serviceResult));
    }




}
