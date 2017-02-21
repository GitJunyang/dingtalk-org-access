package dingtalk.org.access.vo.message;

/**
 * @author zhaoting.yht
 * @since 17/2/14 上午11:11
 */
public class FileMessageVO extends BaseMessageVO {

    private FileContent file;

    public static class FileContent {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    public FileContent getFile() {
        return file;
    }

    public void setFile(FileContent file) {
        this.file = file;
    }
}
