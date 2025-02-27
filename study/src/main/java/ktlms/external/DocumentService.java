package ktlms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "", url = "${api.url.undefined}")
public interface DocumentService {
    @RequestMapping(method= RequestMethod.POST, path="/documents/{id}//uploadfile")
    public void uploadFile(@PathVariable("id")   , @RequestBody UploadFileCommand uploadFileCommand );
}
