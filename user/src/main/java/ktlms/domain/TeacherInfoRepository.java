package ktlms.domain;

import ktlms.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "teacherInfos",
    path = "teacherInfos"
)
public interface TeacherInfoRepository
    extends PagingAndSortingRepository<TeacherInfo, Long> {}
