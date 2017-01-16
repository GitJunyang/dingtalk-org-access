package dingtalk.org.access.service;

import dingtalk.org.access.util.ServiceResult;

/**
 * 企业部门相关服务
 * Created by lifeng.zlf on 2017/1/12.
 */
public interface OrgService {

    /**
     * 获取企业制定部门下的子部门
     * @return
     */
    public ServiceResult<String> getOrgAccessToken();

    /**
     * 获取企业的jsapiticket
     * 注意:每次请求开放平台获得的ticket都是不同的。获取新的ticket老的ticket就会失效掉了
     * @return
     */
    public ServiceResult<String> getOrgJSAPITicket();

}
