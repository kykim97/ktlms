package ktlms.infra;

import java.util.List;
import ktlms.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "dashboards",
    path = "dashboards"
)
public interface DashboardRepository
    extends PagingAndSortingRepository<Dashboard, Long> {}
