package dingtalk.org.access.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by lifeng.zlf on 2017/1/12.
 */
public class OrgServiceImpl implements OrgService {
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("ORG_LOGGER");
    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;

    public ServiceResult<String> getOrgAccessToken() {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.START ));
        try{
            String url = systemConfService.getOapiDomain()+"/gettoken?corpid="+systemConfService.getCorpId()+"&corpsecret="+systemConfService.getCorpSecret();
            String tokenResult = httpRequestHelper.doHttpGet(url);
            JSONObject tokenObject = JSON.parseObject(tokenResult);
            Long errCode = tokenObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "��ȡORG ACCESSTOKENʧ��"
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            return ServiceResult.success(tokenObject.getString("access_token"));
            //TODO ���token��Ҫ��������.û�б�Ҫÿ�ζ�ͨ������ƽ̨ȥ��ȡtoken.�����״�������
            //TODO���ǵ�ǰĬ�ϵ�Ƶ�����ƣ�������̨���ܻ������Ӫ�����������ֵ��
            //TODOÿ����ҵ���õ����ӿڵ�Ƶ�ʲ��ɳ���1500��/��
            //TODOÿ��ISV��Ӧ���ṩ�̣����õ����ӿڵ�Ƶ�ʲ��ɳ���2000��/��
            //TODOÿ��ISV��Ӧ���ṩ�̣����õ�����ҵ�ĵ����ӿ�Ƶ�ʲ��ɳ���1500��/��
            //TODOÿ���׼����õ�����ҵ�ĵ����ӿ�Ƶ�ʲ��ɳ���1000��/��
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "ϵͳ�쳣"
            ),e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }


    public ServiceResult<String> getOrgJSAPITicket() {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.START ));
        try{
            ServiceResult<String> tokenSr = getOrgAccessToken();
            if(!tokenSr.isSuccess()){
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain()+"/get_jsapi_ticket?access_token="+accessToken;
            String ticketResult = httpRequestHelper.doHttpGet(url);
            JSONObject ticketObject = JSON.parseObject(ticketResult);
            Long errCode = ticketObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "��������ʧ��",
                        LogFormatter.KeyValue.getNew("ticketObject", ticketObject)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String ticket = ticketObject.getString("ticket");
            //TODO ע��:ÿ�����󿪷�ƽ̨��õ�ticket���ǲ�ͬ�ġ���ȡ�µ�ticket�ϵ�ticket�ͻ�ʧЧ����
            //TODO ticket��Ҫ�����滺������
            return ServiceResult.success(ticket);
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "ϵͳ�쳣"
            ), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}
