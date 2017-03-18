package dingtalk.org.access.vo.message;

import java.util.List;

/**
 * @author zhaoting.yht
 * @version $Id$
 * @since 17/3/17 上午9:38
 */
public class ActionCardMessageVO extends BaseMessageVO {

    private ActionCardContent action_card;

    public static class ActionCardContent {
        private String title;
        private String markdown;
        private String single_title;
        private String single_url;
        private String btn_orientation;
        private List<BtnJson> btn_json_list;
        private String agentid;

        public static class BtnJson {
            private String title;
            private String action_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAction_url() {
                return action_url;
            }

            public void setAction_url(String action_url) {
                this.action_url = action_url;
            }
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMarkdown() {
            return markdown;
        }

        public void setMarkdown(String markdown) {
            this.markdown = markdown;
        }

        public String getSingle_title() {
            return single_title;
        }

        public void setSingle_title(String single_title) {
            this.single_title = single_title;
        }

        public String getSingle_url() {
            return single_url;
        }

        public void setSingle_url(String single_url) {
            this.single_url = single_url;
        }

        public String getBtn_orientation() {
            return btn_orientation;
        }

        public void setBtn_orientation(String btn_orientation) {
            this.btn_orientation = btn_orientation;
        }

        public List<BtnJson> getBtn_json_list() {
            return btn_json_list;
        }

        public void setBtn_json_list(List<BtnJson> btn_json_list) {
            this.btn_json_list = btn_json_list;
        }

        public String getAgentid() {
            return agentid;
        }

        public void setAgentid(String agentid) {
            this.agentid = agentid;
        }
    }

    public ActionCardContent getAction_card() {
        return action_card;
    }

    public void setAction_card(ActionCardContent action_card) {
        this.action_card = action_card;
    }
}
