package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/13 下午5:44
 */
public class TextMessageVO extends BaseMessageVO {

    private TextContent text;

    public static class TextContent {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public TextContent getText() {
        return text;
    }

    public void setText(TextContent text) {
        this.text = text;
    }
}
