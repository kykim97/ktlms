package ktlms.domain;

import java.time.LocalDate;
import java.util.*;
import ktlms.infra.AbstractEvent;
import lombok.Data;

@Data
public class Submitted extends AbstractEvent {

    private Long id;
    private Long studentId;
    private Long lectureId;
    private String submitted;
}
