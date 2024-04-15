package project.server.certificat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/certificat")
public class CertificatController {
    
    @Autowired
    private CertificatService service ;

    @GetMapping(value = "/{id}")
    Certificat getCertificat(@RequestParam(value = "id") String id) {
        return service.findByID(id);
    }

    


}
