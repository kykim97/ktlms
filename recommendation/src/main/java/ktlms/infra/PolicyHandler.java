package ktlms.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ktlms.config.kafka.KafkaProcessor;
import ktlms.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RecommendationRepository recommendationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StudentApplied'"
    )
    public void wheneverStudentApplied_RecommendLecture(
        @Payload StudentApplied studentApplied
    ) {
        StudentApplied event = studentApplied;
        System.out.println(
            "\n\n##### listener RecommendLecture : " + studentApplied + "\n\n"
        );

        // Sample Logic //
        Recommendation.recommendLecture(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LectureUploaded'"
    )
    public void wheneverLectureUploaded_RecommendLecture(
        @Payload LectureUploaded lectureUploaded
    ) {
        LectureUploaded event = lectureUploaded;
        System.out.println(
            "\n\n##### listener RecommendLecture : " + lectureUploaded + "\n\n"
        );

        // Sample Logic //
        Recommendation.recommendLecture(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
