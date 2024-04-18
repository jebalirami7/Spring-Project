package project.server.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Certificat;
import project.server.Repositories.CertificatRepo;

@Service
public class CertificatService {

    @Autowired
    private CertificatRepo repo;

    public Certificat findById(int id) {
        Optional<Certificat> certif = repo.findById(id);
        if (certif.isPresent())
            return certif.get();
        return null;
    }

    public Certificat createCertificat(Certificat certif) {
        return repo.save(certif);
    }

}
