package dingtalk.org.access.service.impl;

import dingtalk.org.access.service.ChatService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.LogFormatter.KeyValue;
import dingtalk.org.access.util.LogFormatter.LogEvent;
import dingtalk.org.access.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhaoting.yht
 * @version $Id$
 * @since 17/3/16 下午4:39
 */
public class ChatServiceImpl implements ChatService {
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgMessageServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("MESSAGE_LOGGER");

    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;
    @Resource
    private OrgService orgService;

    public ServiceResult<String> chatCreate(String paramJson) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "chatCreate access",
                KeyValue.getNew("paramJson", paramJson)));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/chat/create?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, paramJson);

            bizLogger.info(LogFormatter.getKVLogData(LogEvent.END,
                    KeyValue.getNew("result", resultStr)));

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> chatUpdate(String paramJson) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "chatUpdate access",
                KeyValue.getNew("paramJson", paramJson)));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/chat/update?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, paramJson);

            bizLogger.info(LogFormatter.getKVLogData(LogEvent.END,
                    KeyValue.getNew("result", resultStr)));

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> chatGet(String chatid) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "chatGet access",
                KeyValue.getNew("chatid", chatid)));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/chat/get?access_token=" + accessToken + "&chatid=" + chatid;

            String resultStr = httpRequestHelper.doHttpGet(url);

            bizLogger.info(LogFormatter.getKVLogData(LogEvent.END,
                    KeyValue.getNew("result", resultStr)));

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> chatSend(String paramJson) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "chatSend access",
                KeyValue.getNew("paramJson", paramJson)));
        try {
            ServiceResult<String> tokenSr = orgService.getOrgAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/chat/send?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, paramJson);

            bizLogger.info(LogFormatter.getKVLogData(LogEvent.END,
                    KeyValue.getNew("result", resultStr)));

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}
