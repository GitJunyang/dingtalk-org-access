package dingtalk.org.access.service;

import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.BaseMessageVO;
import dingtalk.org.access.vo.message.ChannelMessageResultVO;

/**
 * 服务窗消息的服务
 *
 * @author zhaoting.yht
 * @since 17/3/20 下午4:55
 */
public interface ChannelMessageService {
    /**
     * 获取服务窗关注者列表
     * @param offset
     * @param size
     * @return
     */
    ServiceResult<String> getUserList(long offset, int size);

    /**
     * 发送服务窗消息
     * @param baseMessageVO
     * @return
     */
    ServiceResult<ChannelMessageResultVO> send(BaseMessageVO baseMessageVO);

    /**
     * 获取发送服务窗会话的进度
     * @param taskid
     * @return
     */
    ServiceResult<String> getSendRate(String taskid);

    /**
     * 获取发送服务窗会话失败的人员的总数量
     * @param taskid
     * @return
     */
    ServiceResult<String> countSendFailed(String taskid);

    /**
     * 获取发送服务窗会话失败的人员的列表
     * @param taskid
     * @param start
     * @return
     */
    ServiceResult<String> listSendFailed(String taskid, int start);
}
