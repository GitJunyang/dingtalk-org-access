package dingtalk.org.access.service.impl;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.OrgMessageService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.LogFormatter.KeyValue;
import dingtalk.org.access.util.LogFormatter.LogEvent;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class OrgMessageServiceImpl implements OrgMessageService {
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgMessageServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("MESSAGE_LOGGER");

    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;
    @Resource
    private OrgService orgService;

    public ServiceResult<OrgMessageResultVO> send(BaseMessageVO baseMessageVO) {
        String message = JSON.toJSONString(baseMessageVO);

        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "messageSend access",
                KeyValue.getNew("messageVO", message)));

        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/message/send?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, message);
            OrgMessageResultVO resultVO = JSON.parseObject(resultStr, OrgMessageResultVO.class);

            return ServiceResult.success(resultVO);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END, "send"), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<ListMessageStatusResultVO> listMessageStatus(ListMessageStatusParamVO paramVO) {
        String param = JSON.toJSONString(paramVO);

        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "listMessageStatus access",
                KeyValue.getNew("param", param)));

        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/message/list_message_status?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, param);
            ListMessageStatusResultVO resultVO = JSON.parseObject(resultStr, ListMessageStatusResultVO.class);

            return ServiceResult.success(resultVO);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END, "send"), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<OrgNormalMessageResultVO> sendToConversation(BaseMessageVO baseMessageVO) {
        String message = JSON.toJSONString(baseMessageVO);

        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "sendToConversation access",
                KeyValue.getNew("messageVO", message)));

        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/message/send_to_conversation?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, message);
            OrgNormalMessageResultVO resultVO = JSON.parseObject(resultStr, OrgNormalMessageResultVO.class);

            return ServiceResult.success(resultVO);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END, "sendToConversation"), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}

