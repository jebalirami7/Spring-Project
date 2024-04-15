package project.server.certificat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificatService {
    
    @Autowired
    private CertificatRepo repo ;



    public Certificat findByID(String id) {
        Optional<Certificat> certif = repo.findById(id);
        if (certif.isPresent())
            return  certif.get();
        else 
            return null ;
    }

}
