package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.server.Entities.Certification;
import project.server.Repositories.CertificationRepository;

import java.util.List;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    @Autowired
    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certification getCertificationById(int id) {
        return certificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Certification not found with id " + id));
    }

    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public void deleteCertification(int id) {
        certificationRepository.deleteById(id);
    }
}
