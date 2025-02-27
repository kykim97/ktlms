package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Registered extends AbstractEvent {

    private Long id;
    private Long lectureId;
    private Long studentId;
    private String achievement;
    private String startingDay;
    private String endingDay;
    private Boolean passed;
    private String submitted;

    public Registered(Registration aggregate) {
        super(aggregate);
    }

    public Registered() {
        super();
    }
}
//>>> DDD / Domain Event
