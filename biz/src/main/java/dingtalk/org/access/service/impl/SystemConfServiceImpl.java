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
       return "dingbf984a817367edee35c2f4657eb6378f";
   }

    public String getCorpSecret(){
        return "6pWjTJNM4IcYfi2c9-d1zt4i4ZEvIJ027D3dBOp61PyziVQQcwsNAmVTxvCBZZeW";
    }
}
