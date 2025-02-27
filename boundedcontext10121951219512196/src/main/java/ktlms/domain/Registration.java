package ktlms.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlms.Boundedcontext10121951219512196Application;
import ktlms.domain.Registered;
import ktlms.domain.Submitted;
import lombok.Data;

@Entity
@Table(name = "Registration_table")
@Data
//<<< DDD / Aggregate Root
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long lectureId;

    private Long studentId;

    private String achievement;

    private String startingDay;

    private String endingDay;

    private Boolean passed;

    private String submitted;

    @PostPersist
    public void onPostPersist() {
        Submitted submitted = new Submitted(this);
        submitted.publishAfterCommit();

        Registered registered = new Registered(this);
        registered.publishAfterCommit();
    }

    public static RegistrationRepository repository() {
        RegistrationRepository registrationRepository = Boundedcontext10121951219512196Application.applicationContext.getBean(
            RegistrationRepository.class
        );
        return registrationRepository;
    }
}
//>>> DDD / Aggregate Root
