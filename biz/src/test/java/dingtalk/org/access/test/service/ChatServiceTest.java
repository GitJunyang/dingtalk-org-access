package dingtalk.org.access.test.service;

import com.alibaba.fastjson.JSON;
import dingtalk.org.access.service.ChatService;
import dingtalk.org.access.test.base.BaseTestCase;
import dingtalk.org.access.util.ServiceResult;
import dingtalk.org.access.vo.message.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServiceTest extends BaseTestCase {

    private String chatid = "";
    private String name = "演示群";
    private String nameUpdate = "演示群Update";
    private String owner = "manager5351";

    @Resource
    private ChatService chatService;

    @Test
    public void testChatCreate() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        params.put("owner", owner);

        List<String> useridlist = new ArrayList<String>();
        useridlist.add(owner);
        params.put("useridlist", useridlist);

        ServiceResult<String> sr = chatService.chatCreate(JSON.toJSONString(params));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testChatUpdate() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("chatid", chatid);
        params.put("name", nameUpdate);
        params.put("owner", owner);

        List<String> addUseridlist = new ArrayList<String>();
        addUseridlist.add(owner);
        params.put("add_useridlist", addUseridlist);

//        List<String> delUseridlist = new ArrayList<String>();
//        delUseridlist.add(owner);
//        params.put("del_useridlist", delUseridlist);

        ServiceResult<String> sr = chatService.chatUpdate(JSON.toJSONString(params));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testChatGet() {
        ServiceResult<String> sr = chatService.chatGet(chatid);
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendTextMessage() {
        TextMessageVO messageVO = new TextMessageVO();

        messageVO.setChatid(chatid);
        messageVO.setMsgtype("text");

        TextMessageVO.TextContent content = new TextMessageVO.TextContent();
        content.setContent("这是文本类型消息");
        messageVO.setText(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendImageMessage() {
        ImageMessageVO messageVO = new ImageMessageVO();

        messageVO.setMsgtype("image");
        messageVO.setChatid(chatid);

        ImageMessageVO.ImageContent content = new ImageMessageVO.ImageContent();
        content.setMedia_id("@lADOpJiZPMyYzJw");
        messageVO.setImage(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendVoiceMessage() {
        VoiceMessageVO messageVO = new VoiceMessageVO();

        messageVO.setMsgtype("voice");
        messageVO.setChatid(chatid);

        VoiceMessageVO.VoiceContent content = new VoiceMessageVO.VoiceContent();
        content.setMedia_id("@lATOpqw2X85bZwEAziJlJE8");
        content.setDuration("4");
        messageVO.setVoice(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendFileMessage() {
        FileMessageVO messageVO = new FileMessageVO();

        messageVO.setMsgtype("file");
        messageVO.setChatid(chatid);

        FileMessageVO.FileContent content = new FileMessageVO.FileContent();
        content.setMedia_id("@lArOeNStu84eVtCmzkKwBQg");
        messageVO.setFile(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendLinkMessage() {
        LinkMessageVO messageVO = new LinkMessageVO();

        messageVO.setMsgtype("link");
        messageVO.setChatid(chatid);

        LinkMessageVO.LinkContent content = new LinkMessageVO.LinkContent();
        content.setMessageUrl("https://www.dingtalk.com");
        content.setPicUrl("@lALOACZwe2Rk");
        content.setText("link消息描述");
        content.setTitle("link消息标题");
        messageVO.setLink(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendOAMessage() {
        OAMessageVO messageVO = new OAMessageVO();

        messageVO.setMsgtype("oa");
        messageVO.setChatid(chatid);

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

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    private OAMessageVO.OAContent.OABody.OAForm createOAForm(String key, String value) {
        OAMessageVO.OAContent.OABody.OAForm oaForm = new OAMessageVO.OAContent.OABody.OAForm();
        oaForm.setKey(key);
        oaForm.setValue(value);
        return oaForm;
    }

    @Test
    public void testSendActionCardMessageNoAction() {
        ActionCardMessageVO messageVO = new ActionCardMessageVO();

        messageVO.setMsgtype("action_card");
        messageVO.setChatid(chatid);

        ActionCardMessageVO.ActionCardContent content = new ActionCardMessageVO.ActionCardContent();
        content.setTitle("测试actionCard");
        content.setMarkdown("# 这是支持markdown的文本 \n ## 标题2 \n * 列表1 \n * 列表2");

        // content.setAgentid(""); // 微应用id，可选
        messageVO.setAction_card(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendActionCardMessageSingleAction() {
        ActionCardMessageVO messageVO = new ActionCardMessageVO();

        messageVO.setMsgtype("action_card");
        messageVO.setChatid(chatid);

        ActionCardMessageVO.ActionCardContent content = new ActionCardMessageVO.ActionCardContent();
        content.setTitle("测试actionCard");
        content.setMarkdown("# 这是支持markdown的文本 \n ## 标题2 \n * 列表1 \n * 列表2");
        content.setSingle_title("singleTitle");
        content.setSingle_url("https://open.dingtalk.com");

        // content.setAgentid(""); // 微应用id，可选
        messageVO.setAction_card(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendActionCardMessageMultiActionHorizontal() {
        ActionCardMessageVO messageVO = new ActionCardMessageVO();

        messageVO.setMsgtype("action_card");
        messageVO.setChatid(chatid);

        ActionCardMessageVO.ActionCardContent content = new ActionCardMessageVO.ActionCardContent();
        content.setTitle("测试actionCard");
        content.setMarkdown("# 这是支持markdown的文本 \n ## 标题2 \n * 列表1 \n * 列表2");
        content.setBtn_orientation("1");
        List<ActionCardMessageVO.ActionCardContent.BtnJson> btnJsonList = new ArrayList<ActionCardMessageVO.ActionCardContent.BtnJson>();
        btnJsonList.add(getBtnJson("一个按钮", "https://www.taobao.com"));
        btnJsonList.add(getBtnJson("两个按钮", "https://www.tmall.com"));
        content.setBtn_json_list(btnJsonList);

        // content.setAgentid(""); // 微应用id，可选
        messageVO.setAction_card(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    @Test
    public void testSendActionCardMessageMultiActionVertical() {
        ActionCardMessageVO messageVO = new ActionCardMessageVO();

        messageVO.setMsgtype("action_card");
        messageVO.setChatid(chatid);

        ActionCardMessageVO.ActionCardContent content = new ActionCardMessageVO.ActionCardContent();
        content.setTitle("测试actionCard");
        content.setMarkdown("# 这是支持markdown的文本 \n ## 标题2 \n * 列表1 \n * 列表2");
        content.setBtn_orientation("0");
        List<ActionCardMessageVO.ActionCardContent.BtnJson> btnJsonList = new ArrayList<ActionCardMessageVO.ActionCardContent.BtnJson>();
        btnJsonList.add(getBtnJson("一个按钮", "https://www.taobao.com"));
        btnJsonList.add(getBtnJson("两个按钮", "https://www.tmall.com"));
        content.setBtn_json_list(btnJsonList);

        // content.setAgentid(""); // 微应用id，可选
        messageVO.setAction_card(content);

        ServiceResult<String> sr = chatService.chatSend(JSON.toJSONString(messageVO));
        System.out.println(JSON.toJSONString(sr));
    }

    private ActionCardMessageVO.ActionCardContent.BtnJson getBtnJson(String title, String actionUrl) {
        ActionCardMessageVO.ActionCardContent.BtnJson btnJson = new ActionCardMessageVO.ActionCardContent.BtnJson();
        btnJson.setTitle(title);
        btnJson.setAction_url(actionUrl);
        return btnJson;
    }

}
