package dingtalk.org.access.service;

import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.*;

/**
 * @author zhaoting.yht
 * @since 17/2/13 下午5:25
 */
public interface OrgMessageService {

    /**
     * 发送企业会话消息
     * @param baseMessageVO
     * @return
     */
    ServiceResult<OrgMessageResultVO> send(BaseMessageVO baseMessageVO);

    /**
     * 获取企业会话消息已读未读状态
     * @param paramVO
     * @return
     */
    ServiceResult<ListMessageStatusResultVO> listMessageStatus(ListMessageStatusParamVO paramVO);

    /**
     * 发送普通会话消息
     * @param baseMessageVO
     * @return
     */
    ServiceResult<OrgNormalMessageResultVO> sendToConversation(BaseMessageVO baseMessageVO);
}
