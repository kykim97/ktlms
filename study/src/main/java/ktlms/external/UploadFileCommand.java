package ktlms.external;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class UploadFileCommand {

    @Id
    private Long id;
}
