package ktlms.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlms.StudyApplication;
import ktlms.domain.LectureUploaded;
import lombok.Data;

@Entity
@Table(name = "Lecture_table")
@Data
//<<< DDD / Aggregate Root
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lectureId;

    private String 강의명;

    private String 강의설명;

    private String 파일유형;

    private String 강사명;

    private Long documentId;

    private Boolean 강의상태;

    private String 강의시작일;

    private String 강의종료일;

    private String 수료기준;

    private String 강의분류;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        ktlms.external.UploadFileCommand uploadFileCommand = new ktlms.external.UploadFileCommand();
        // mappings goes here
        StudyApplication.applicationContext
            .getBean(ktlms.external.DocumentService.class)
            .uploadFile(/* get???(), */uploadFileCommand);

        LectureUploaded lectureUploaded = new LectureUploaded(this);
        lectureUploaded.publishAfterCommit();
    }

    public static LectureRepository repository() {
        LectureRepository lectureRepository = StudyApplication.applicationContext.getBean(
            LectureRepository.class
        );
        return lectureRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addLecture(FileSaved fileSaved) {
        //implement business logic here:

        /** Example 1:  new item 
        Lecture lecture = new Lecture();
        repository().save(lecture);

        */

        /** Example 2:  finding and process
        

        repository().findById(fileSaved.get???()).ifPresent(lecture->{
            
            lecture // do something
            repository().save(lecture);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
