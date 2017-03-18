package dingtalk.org.access.service;

import dingtalk.org.access.util.ServiceResult;

/**
 * 群会话接口相关的服务
 * @author zhaoting.yht
 * @since 17/3/16 下午4:37
 */
public interface ChatService {

    /**
     * 创建群会话
     * @param paramJson
     * @return
     */
    ServiceResult<String> chatCreate(String paramJson);

    /**
     * 更新群会话
     * @param paramJson
     * @return
     */
    ServiceResult<String> chatUpdate(String paramJson);

    /**
     * 查询群会话
     * @param chatid
     * @return
     */
    ServiceResult<String> chatGet(String chatid);

    /**
     * 发送群会话消息
     * @param paramJson
     * @return
     */
    ServiceResult<String> chatSend(String paramJson);
}
