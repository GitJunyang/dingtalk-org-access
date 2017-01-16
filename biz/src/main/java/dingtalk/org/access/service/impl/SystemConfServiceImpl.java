package dingtalk.org.access.service.impl;

import dingtalk.org.access.service.OrgDeptService;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.ServiceResult;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class SystemConfServiceImpl {
    public String getOapiDomain(){
        return "https://oapi.dingtalk.com";
    }

   public String getCorpId(){
       return "ding9f50b15bccd16741";
   }

    public String getCorpSecret(){
        return "JEfxq2g9uwSL049ErjBYUaJcR6sM0duWoGcz7W8ews17lhGCLyfh9NjgbLYYJ_pt";
    }
}
