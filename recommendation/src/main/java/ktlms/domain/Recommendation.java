package ktlms.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlms.RecommendationApplication;
import ktlms.domain.LectureRecommended;
import lombok.Data;

@Entity
@Table(name = "Recommendation_table")
@Data
//<<< DDD / Aggregate Root
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studentId;

    private String lectureId;

    private String recommendation;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        ktlms.external.Reservation reservation = new ktlms.external.Reservation();
        // mappings goes here
        RecommendationApplication.applicationContext
            .getBean(ktlms.external.ReservationService.class)
            .createReservation(reservation);

        LectureRecommended lectureRecommended = new LectureRecommended(this);
        lectureRecommended.publishAfterCommit();
    }

    public static RecommendationRepository repository() {
        RecommendationRepository recommendationRepository = RecommendationApplication.applicationContext.getBean(
            RecommendationRepository.class
        );
        return recommendationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recommendLecture(StudentApplied studentApplied) {
        //implement business logic here:

        /** Example 1:  new item 
        Recommendation recommendation = new Recommendation();
        repository().save(recommendation);

        */

        /** Example 2:  finding and process
        

        repository().findById(studentApplied.get???()).ifPresent(recommendation->{
            
            recommendation // do something
            repository().save(recommendation);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recommendLecture(LectureUploaded lectureUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Recommendation recommendation = new Recommendation();
        repository().save(recommendation);

        */

        /** Example 2:  finding and process
        

        repository().findById(lectureUploaded.get???()).ifPresent(recommendation->{
            
            recommendation // do something
            repository().save(recommendation);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
