package ktlms.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlms.UserApplication;
import ktlms.domain.TeacherInfoApplied;
import lombok.Data;

@Entity
@Table(name = "TeacherInfo_table")
@Data
//<<< DDD / Aggregate Root
public class TeacherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacherId;

    private String name;

    private String teacherNo;

    @PostPersist
    public void onPostPersist() {
        TeacherInfoApplied teacherInfoApplied = new TeacherInfoApplied(this);
        teacherInfoApplied.publishAfterCommit();
    }

    public static TeacherInfoRepository repository() {
        TeacherInfoRepository teacherInfoRepository = UserApplication.applicationContext.getBean(
            TeacherInfoRepository.class
        );
        return teacherInfoRepository;
    }
}
//>>> DDD / Aggregate Root
