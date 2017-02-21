package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.OrgMessageService;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class OrgMessageServiceTest extends BaseTestCase {
    private String agentid = "77448754";
    private String touser = "manager5351";
    private String toparty = "29446552";

    @Resource
    private OrgMessageService orgMessageService;

    @Test
    public void testSendTextMessage() {
        TextMessageVO messageVO = new TextMessageVO();

        messageVO.setMsgtype("text");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        TextMessageVO.TextContent content = new TextMessageVO.TextContent();
        content.setContent("这是文本类型消息");
        messageVO.setText(content);

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendImageMessage() {
        ImageMessageVO messageVO = new ImageMessageVO();

        messageVO.setMsgtype("image");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        ImageMessageVO.ImageContent content = new ImageMessageVO.ImageContent();
        content.setMedia_id("@lADOpJiZPMyYzJw");
        messageVO.setImage(content);

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendVoiceMessage() {
        VoiceMessageVO messageVO = new VoiceMessageVO();

        messageVO.setMsgtype("voice");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        VoiceMessageVO.VoiceContent content = new VoiceMessageVO.VoiceContent();
        content.setMedia_id("@lATOpqw2X85bZwEAziJlJE8");
        content.setDuration("4");
        messageVO.setVoice(content);

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendFileMessage() {
        FileMessageVO messageVO = new FileMessageVO();

        messageVO.setMsgtype("file");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        FileMessageVO.FileContent content = new FileMessageVO.FileContent();
        content.setMedia_id("@lArOeNStu84eVtCmzkKwBQg");
        messageVO.setFile(content);

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendLinkMessage() {
        LinkMessageVO messageVO = new LinkMessageVO();

        messageVO.setMsgtype("link");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        LinkMessageVO.LinkContent content = new LinkMessageVO.LinkContent();
        content.setMessageUrl("https://www.dingtalk.com");
        content.setPicUrl("@lALOACZwe2Rk");
        content.setText("link消息描述");
        content.setTitle("link消息标题");
        messageVO.setLink(content);

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendOAMessage() {
        OAMessageVO messageVO = new OAMessageVO();

        messageVO.setMsgtype("oa");
        messageVO.setAgentid(agentid);
        messageVO.setTouser(touser);
        messageVO.setToparty(toparty);

        OAMessageVO.OAContent content = new OAMessageVO.OAContent();
        content.setMessage_url("http://www.dingtalk.com");
        content.setPc_message_url("http://www.dingtalk.com");

        // head
        OAMessageVO.OAContent.OAHead oaHead = new OAMessageVO.OAContent.OAHead();
        oaHead.setBgcolor("FFBBBBBB");
        content.setHead(oaHead);

        // body
        OAMessageVO.OAContent.OABody oaBody = new OAMessageVO.OAContent.OABody();
        oaBody.setTitle("正文标题");
        oaBody.setContent("大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
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

        ServiceResult<OrgMessageResultVO> sr = orgMessageService.send(messageVO);
        System.out.println(JSON.toJSONString(sr));
    }

    private OAMessageVO.OAContent.OABody.OAForm createOAForm(String key, String value) {
        OAMessageVO.OAContent.OABody.OAForm oaForm = new OAMessageVO.OAContent.OABody.OAForm();
        oaForm.setKey(key);
        oaForm.setValue(value);
        return oaForm;
    }

    @Test
    public void testListMessageStatus() {
        ListMessageStatusParamVO paramVO = new ListMessageStatusParamVO();
        paramVO.setMessageId("84b0c35490583e4693efc8a9f205f2bf");

        ServiceResult<ListMessageStatusResultVO> sr = orgMessageService.listMessageStatus(paramVO);
        System.out.println(JSON.toJSONString(sr));
    }
}
