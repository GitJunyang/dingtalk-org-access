package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/14 上午11:10
 */
public class VoiceMessageVO extends BaseMessageVO {

    private VoiceContent voice;

    public static class VoiceContent {
        private String media_id;
        private String duration;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }

    public VoiceContent getVoice() {
        return voice;
    }

    public void setVoice(VoiceContent voice) {
        this.voice = voice;
    }
}
