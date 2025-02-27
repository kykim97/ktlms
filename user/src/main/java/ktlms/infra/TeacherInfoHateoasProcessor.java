package ktlms.infra;

import ktlms.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class TeacherInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<TeacherInfo>> {

    @Override
    public EntityModel<TeacherInfo> process(EntityModel<TeacherInfo> model) {
        return model;
    }
}
