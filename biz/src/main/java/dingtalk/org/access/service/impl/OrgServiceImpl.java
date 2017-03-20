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
 * @since 17/3/20 下午4:58
 */
public class OrgServiceImpl implements OrgService{
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("ORG_LOGGER");
    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;

    public ServiceResult<String> getOrgAccessToken() {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.START));
        try{
            String url = systemConfService.getOapiDomain()+"/gettoken?corpid="+systemConfService.getCorpId()+"&corpsecret="+systemConfService.getCorpSecret();
            String tokenResult = httpRequestHelper.doHttpGet(url);
            JSONObject tokenObject = JSON.parseObject(tokenResult);
            Long errCode = tokenObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "获取ORG ACCESSTOKEN失败"
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            return ServiceResult.success(tokenObject.getString("access_token"));
            //TODO 这个token需要缓存起来.没有必要每次都通过开放平台去获取token.很容易触发流控
            //TODO下是当前默认的频率限制，钉钉后台可能会根据运营情况调整此阈值：
            //TODO每个企业调用单个接口的频率不可超过1500次/分
            //TODO每个ISV（应用提供商）调用单个接口的频率不可超过2000次/分
            //TODO每个ISV（应用提供商）调用单个企业的单个接口频率不可超过1500次/分
            //TODO每个套件调用单个企业的单个接口频率不可超过1000次/分
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "系统异常"
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
                        "创建部门失败",
                        LogFormatter.KeyValue.getNew("ticketObject", ticketObject)
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String ticket = ticketObject.getString("ticket");
            //TODO 注意:每次请求开放平台获得的ticket都是不同的。获取新的ticket老的ticket就会失效掉了
            //TODO ticket需要做缓存缓存起来
            return ServiceResult.success(ticket);
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "系统异常"
            ), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> getChannelAccessToken() {
        bizLogger.info(LogFormatter.getKVLogData(LogFormatter.LogEvent.START));
        try{
            String url = systemConfService.getOapiDomain()+"/channel/get_channel_token?corpid="+systemConfService.getCorpId()+"&channel_secret="+systemConfService.getChannelSecret();
            String tokenResult = httpRequestHelper.doHttpGet(url);
            JSONObject tokenObject = JSON.parseObject(tokenResult);
            Long errCode = tokenObject.getLong("errcode");
            if(null==errCode || errCode.intValue()!=0){
                bizLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                        "获取CHANNEL ACCESSTOKEN失败"
                ));
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            return ServiceResult.success(tokenObject.getString("access_token"));
            //TODO 这个token需要缓存起来.没有必要每次都通过开放平台去获取token.很容易触发流控
            //TODO下是当前默认的频率限制，钉钉后台可能会根据运营情况调整此阈值：
            //TODO每个企业调用单个接口的频率不可超过1500次/分
            //TODO每个ISV（应用提供商）调用单个接口的频率不可超过2000次/分
            //TODO每个ISV（应用提供商）调用单个企业的单个接口频率不可超过1500次/分
            //TODO每个套件调用单个企业的单个接口频率不可超过1000次/分
        }catch (Throwable e){
            mainLogger.error(LogFormatter.getKVLogData(LogFormatter.LogEvent.END,
                    "系统异常"
            ),e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}
