package ktlms.external;

import java.util.Date;
import lombok.Data;

@Data
public class Document {

    private Long id;
    private String name;
    private String filePath;
    private String previewPath;
    private Date timeStamp;
    private String status;
    private String reason;
}
