package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/14 上午11:12
 */
public class LinkMessageVO extends BaseMessageVO {

    private LinkContent link;

    public static class LinkContent {
        private String messageUrl;
        private String picUrl;
        private String title;
        private String text;

        /**
         * 服务窗应用发消息需要使用这两个参数
         */
        private String message_url;
        private String pic_url;

        public String getMessageUrl() {
            return messageUrl;
        }

        public void setMessageUrl(String messageUrl) {
            this.messageUrl = messageUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getMessage_url() {
            return message_url;
        }

        public void setMessage_url(String message_url) {
            this.message_url = message_url;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }

    public LinkContent getLink() {
        return link;
    }

    public void setLink(LinkContent link) {
        this.link = link;
    }
}
