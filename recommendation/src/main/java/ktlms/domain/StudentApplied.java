package ktlms.domain;

import java.util.*;
import ktlms.domain.*;
import ktlms.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class StudentApplied extends AbstractEvent {

    private Long studentId;
    private String name;
    private Integer studentNo;
    private String interest;
}
