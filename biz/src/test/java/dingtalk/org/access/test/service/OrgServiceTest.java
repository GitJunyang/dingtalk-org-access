package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgServiceTest extends BaseTestCase {
    @Resource
    private OrgService orgService;

    @Test
    public void test_getOrgAccessToken(){
        ServiceResult<String> serviceResult = orgService.getOrgAccessToken();
        System.err.println(JSON.toJSONString(serviceResult));
    }


    @Test
    public void test_getOrgJSAPITicket(){
        ServiceResult<String> serviceResult = orgService.getOrgJSAPITicket();
        System.err.println(JSON.toJSONString(serviceResult));
    }


    @Test
    public void test_getChannelAccessToken(){
        ServiceResult<String> serviceResult = orgService.getChannelAccessToken();
        System.err.println(JSON.toJSONString(serviceResult));
    }
}
