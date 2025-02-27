package ktlms.domain;

import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class FileSaved extends AbstractEvent {

    private Long id;
    private String name;
    private String filePath;
    private String previewPath;
    private Date timeStamp;
    private String status;
    private String reason;
}
