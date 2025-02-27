package ktlms.domain;

import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class LectureUploaded extends AbstractEvent {

    private Long lectureId;
    private String 강의명;
    private String 강의설명;
    private String 파일유형;
    private String 강사명;
    private Long documentId;
    private Boolean 강의상태;
    private String 강의시작일;
    private String 강의종료일;
    private String 수료기준;
    private String 강의분류;
}
