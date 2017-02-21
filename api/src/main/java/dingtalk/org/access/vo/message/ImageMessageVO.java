package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/13 下午5:47
 */
public class ImageMessageVO extends BaseMessageVO {

    private ImageContent image;

    public static class ImageContent {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    public ImageContent getImage() {
        return image;
    }

    public void setImage(ImageContent image) {
        this.image = image;
    }
}
