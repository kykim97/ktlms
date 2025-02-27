package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.infra.AbstractEvent;
import lombok.Data;

@Data
public class Registered extends AbstractEvent {

    private Long id;
    private Long lectureId;
    private Long studentId;
    private String achievement;
    private String startingDay;
    private String endingDay;
    private Boolean passed;
    private String submitted;
}
