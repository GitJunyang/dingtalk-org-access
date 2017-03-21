package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.ChannelMessageService;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ChannelMessageServiceTest extends BaseTestCase {
    private String channelAgentId = "";
    private String touser = "";
    private String taskid = "";

    @Resource
    private ChannelMessageService channelMessageService;

    @Test
    public void testGetUserList() {
        ServiceResult<String> sr = channelMessageService.getUserList(0, 20);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendTextMessage() {
        TextMessageVO messageVO = new TextMessageVO();

        messageVO.setMsgtype("text");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        TextMessageVO.TextContent content = new TextMessageVO.TextContent();
        content.setContent("这是文本类型的消息");
        messageVO.setText(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendImageMessage() {
        ImageMessageVO messageVO = new ImageMessageVO();

        messageVO.setMsgtype("image");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        ImageMessageVO.ImageContent content = new ImageMessageVO.ImageContent();
        content.setMedia_id("@lADOpJiZPMyYzJw");
        messageVO.setImage(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendVoiceMessage() {
        VoiceMessageVO messageVO = new VoiceMessageVO();

        messageVO.setMsgtype("voice");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        VoiceMessageVO.VoiceContent content = new VoiceMessageVO.VoiceContent();
        content.setMedia_id("@lATOpqw2X85bZwEAziJlJE8");
        content.setDuration("4");
        messageVO.setVoice(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendFileMessage() {
        FileMessageVO messageVO = new FileMessageVO();

        messageVO.setMsgtype("file");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        FileMessageVO.FileContent content = new FileMessageVO.FileContent();
        content.setMedia_id("@lArOeNStu84eVtCmzkKwBQg");
        messageVO.setFile(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendLinkMessage() {
        LinkMessageVO messageVO = new LinkMessageVO();

        messageVO.setMsgtype("link");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        LinkMessageVO.LinkContent content = new LinkMessageVO.LinkContent();
        content.setMessage_url("https://www.dingtalk.com");
        content.setPic_url("@lALOACZwe2Rk");
        content.setText("link消息描述");
        content.setTitle("link消息标题");
        messageVO.setLink(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendOAMessage() {
        OAMessageVO messageVO = new OAMessageVO();

        messageVO.setMsgtype("oa");
        messageVO.setChannelAgentId(channelAgentId);
        messageVO.setTouser(touser);

        OAMessageVO.OAContent content = new OAMessageVO.OAContent();
        content.setMessage_url("http://www.dingtalk.com");
        content.setPc_message_url("http://www.dingtalk.com");

        // head
        OAMessageVO.OAContent.OAHead oaHead = new OAMessageVO.OAContent.OAHead();
        oaHead.setBgcolor("FFBBBBBB");
        oaHead.setText("头部标题");
        content.setHead(oaHead);

        // body
        OAMessageVO.OAContent.OABody oaBody = new OAMessageVO.OAContent.OABody();
        oaBody.setTitle("正文标题");
        oaBody.setContent("大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段");
        oaBody.setImage("@lADOADmaWMzazQKA");
        oaBody.setFile_count("3");
        oaBody.setAuthor("李四");
        List<OAMessageVO.OAContent.OABody.OAForm> formList = new ArrayList<OAMessageVO.OAContent.OABody.OAForm>();
        formList.add(createOAForm("姓名:", "张三"));
        formList.add(createOAForm("年龄:", "20"));
        formList.add(createOAForm("爱好:", "打球、听音乐"));
        oaBody.setForm(formList);
        OAMessageVO.OAContent.OABody.OARich oaRich = new OAMessageVO.OAContent.OABody.OARich();
        oaRich.setNum("15.6");
        oaRich.setUnit("元");
        oaBody.setRich(oaRich);
        content.setBody(oaBody);

        messageVO.setOa(content);

        ServiceResult<ChannelMessageResultVO> sr = channelMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    private OAMessageVO.OAContent.OABody.OAForm createOAForm(String key, String value) {
        OAMessageVO.OAContent.OABody.OAForm oaForm = new OAMessageVO.OAContent.OABody.OAForm();
        oaForm.setKey(key);
        oaForm.setValue(value);
        return oaForm;
    }

    @Test
    public void testGetSendRate() {
        ServiceResult<String> sr = channelMessageService.getSendRate(taskid);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testCountSendFailed() {
        ServiceResult<String> sr = channelMessageService.countSendFailed(taskid);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testListSendFailed() {
        int start = 0;
        ServiceResult<String> sr = channelMessageService.listSendFailed(taskid, start);
        System.out.println(JSON.toJSONString(sr));
    }
}
