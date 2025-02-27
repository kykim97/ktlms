package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StudentApplied extends AbstractEvent {

    private Long studentId;
    private String name;
    private Integer studentNo;
    private String interest;

    public StudentApplied(StudentInfo aggregate) {
        super(aggregate);
    }

    public StudentApplied() {
        super();
    }
}
//>>> DDD / Domain Event
