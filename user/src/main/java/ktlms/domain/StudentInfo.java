package ktlms.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlms.UserApplication;
import ktlms.domain.StudentApplied;
import lombok.Data;

@Entity
@Table(name = "StudentInfo_table")
@Data
//<<< DDD / Aggregate Root
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String name;

    private Integer studentNo;

    private String interest;

    @PostPersist
    public void onPostPersist() {
        StudentApplied studentApplied = new StudentApplied(this);
        studentApplied.publishAfterCommit();
    }

    public static StudentInfoRepository repository() {
        StudentInfoRepository studentInfoRepository = UserApplication.applicationContext.getBean(
            StudentInfoRepository.class
        );
        return studentInfoRepository;
    }
}
//>>> DDD / Aggregate Root
