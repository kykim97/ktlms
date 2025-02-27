package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Submitted extends AbstractEvent {

    private Long id;
    private Long studentId;
    private Long lectureId;
    private String submitted;

    public Submitted(Registration aggregate) {
        super(aggregate);
    }

    public Submitted() {
        super();
    }
}
//>>> DDD / Domain Event
