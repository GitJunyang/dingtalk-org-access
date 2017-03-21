package dingtalk.org.access.service.impl;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.ChannelMessageService;
import dingtalk.org.access.service.OrgService;
import dingtalk.org.access.util.ErrorCode;
import dingtalk.org.access.util.HttpRequestHelper;
import dingtalk.org.access.util.LogFormatter;
import dingtalk.org.access.util.LogFormatter.KeyValue;
import dingtalk.org.access.util.LogFormatter.LogEvent;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.BaseMessageVO;
import dingtalk.org.access.vo.message.ChannelMessageResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhaoting.yht
 * @since 17/3/20 下午5:10
 */
public class ChannelMessageServiceImpl implements ChannelMessageService{
    private static final Logger mainLogger = LoggerFactory.getLogger(OrgMessageServiceImpl.class);
    private static final Logger bizLogger = LoggerFactory.getLogger("MESSAGE_LOGGER");

    @Resource
    private HttpRequestHelper httpRequestHelper;
    @Resource
    private SystemConfServiceImpl systemConfService;
    @Resource
    private OrgService orgService;

    public ServiceResult<String> getUserList(long offset, int size) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "getUserList access",
                KeyValue.getNew("offset", offset),
                KeyValue.getNew("size", size)));

        try {
            ServiceResult<String> tokenSr = orgService.getChannelAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/channel/user/list?access_token=" + accessToken + "&offset="
                    + offset + "&size=" + size;

            String resultStr = httpRequestHelper.doHttpGet(url);

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<ChannelMessageResultVO> send(BaseMessageVO baseMessageVO) {
        String message = JSON.toJSONString(baseMessageVO);

        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "messageSend access",
                KeyValue.getNew("messageVO", message)));

        try {
            ServiceResult<String> tokenSr = orgService.getChannelAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/channel/message/send?access_token=" + accessToken;

            String resultStr = httpRequestHelper.httpPostJson(url, message);
            ChannelMessageResultVO resultVO = JSON.parseObject(resultStr, ChannelMessageResultVO.class);

            return ServiceResult.success(resultVO);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> getSendRate(String taskid) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "getSendRate access",
                KeyValue.getNew("taskid", taskid)));

        try {
            ServiceResult<String> tokenSr = orgService.getChannelAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/channel/message/getSendRate?access_token=" + accessToken
                    + "&taskid=" + taskid;

            String resultStr = httpRequestHelper.doHttpGet(url);

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> countSendFailed(String taskid) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "countSendFailed access",
                KeyValue.getNew("taskid", taskid)));

        try {
            ServiceResult<String> tokenSr = orgService.getChannelAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/channel/message/countSendFailed?access_token=" + accessToken
                    + "&taskid=" + taskid;

            String resultStr = httpRequestHelper.doHttpGet(url);

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }

    public ServiceResult<String> listSendFailed(String taskid, int start) {
        bizLogger.info(LogFormatter.getKVLogData(LogEvent.END, "listSendFailed access",
                KeyValue.getNew("taskid", taskid),
                KeyValue.getNew("start", start)));

        try {
            ServiceResult<String> tokenSr = orgService.getChannelAccessToken();
            if (!tokenSr.isSuccess()) {
                return ServiceResult.failure(ErrorCode.SYS_ERROR);
            }
            String accessToken = tokenSr.getResult();
            String url = systemConfService.getOapiDomain() + "/channel/message/listSendFailed?access_token=" + accessToken
                    + "&taskid=" + taskid + "&start=" + start;

            String resultStr = httpRequestHelper.doHttpGet(url);

            return ServiceResult.success(resultStr);
        } catch (Throwable e) {
            mainLogger.error(LogFormatter.getKVLogData(LogEvent.END), e);
            return ServiceResult.failure(ErrorCode.SYS_ERROR);
        }
    }
}
