package ktlms.infra;

import ktlms.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<StudentInfo>> {

    @Override
    public EntityModel<StudentInfo> process(EntityModel<StudentInfo> model) {
        return model;
    }
}
