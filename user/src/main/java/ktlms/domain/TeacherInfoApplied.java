package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TeacherInfoApplied extends AbstractEvent {

    private Long teacherId;
    private String name;
    private String teacherNo;

    public TeacherInfoApplied(TeacherInfo aggregate) {
        super(aggregate);
    }

    public TeacherInfoApplied() {
        super();
    }
}
//>>> DDD / Domain Event
