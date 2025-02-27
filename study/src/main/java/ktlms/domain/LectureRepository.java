package ktlms.domain;

import ktlms.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "lectures", path = "lectures")
public interface LectureRepository
    extends PagingAndSortingRepository<Lecture, Long> {}
