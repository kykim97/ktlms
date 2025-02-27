package ktlms.domain;

import ktlms.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "studentInfos",
    path = "studentInfos"
)
public interface StudentInfoRepository
    extends PagingAndSortingRepository<StudentInfo, Long> {}
