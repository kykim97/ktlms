package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureRecommended extends AbstractEvent {

    private Long id;

    public LectureRecommended(Recommendation aggregate) {
        super(aggregate);
    }

    public LectureRecommended() {
        super();
    }
}
//>>> DDD / Domain Event
