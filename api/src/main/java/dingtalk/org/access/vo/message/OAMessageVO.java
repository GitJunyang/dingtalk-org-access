package dingtalk.org.access.vo.message;

import java.util.List;

/**
 * @author zhaoting.yht
 * @since 17/2/14 上午11:17
 */
public class OAMessageVO extends BaseMessageVO {

    private OAContent oa;

    public static class OAContent {
        private String message_url;
        private String pc_message_url;
        private OAHead head;
        private OABody body;

        public static class OAHead {
            private String bgcolor;
            private String text;

            public String getBgcolor() {
                return bgcolor;
            }

            public void setBgcolor(String bgcolor) {
                this.bgcolor = bgcolor;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }

        public static class OABody {
            private String title;
            private String content;
            private String image;
            private String file_count;
            private String author;
            private List<OAForm> form;
            private OARich rich;

            public static class OARich {
                private String num;
                private String unit;

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }
            }

            public static class OAForm {
                private String key;
                private String value;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getFile_count() {
                return file_count;
            }

            public void setFile_count(String file_count) {
                this.file_count = file_count;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public List<OAForm> getForm() {
                return form;
            }

            public void setForm(List<OAForm> form) {
                this.form = form;
            }

            public OARich getRich() {
                return rich;
            }

            public void setRich(OARich rich) {
                this.rich = rich;
            }
        }

        public String getMessage_url() {
            return message_url;
        }

        public void setMessage_url(String message_url) {
            this.message_url = message_url;
        }

        public String getPc_message_url() {
            return pc_message_url;
        }

        public void setPc_message_url(String pc_message_url) {
            this.pc_message_url = pc_message_url;
        }

        public OAHead getHead() {
            return head;
        }

        public void setHead(OAHead head) {
            this.head = head;
        }

        public OABody getBody() {
            return body;
        }

        public void setBody(OABody body) {
            this.body = body;
        }
    }

    public OAContent getOa() {
        return oa;
    }

    public void setOa(OAContent oa) {
        this.oa = oa;
    }
}
