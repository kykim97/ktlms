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
    LectureRepository lectureRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileSaved'"
    )
    public void wheneverFileSaved_AddLecture(@Payload FileSaved fileSaved) {
        FileSaved event = fileSaved;
        System.out.println(
            "\n\n##### listener AddLecture : " + fileSaved + "\n\n"
        );

        // Sample Logic //
        Lecture.addLecture(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
