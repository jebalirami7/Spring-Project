package project.server.certificat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatRepo extends JpaRepository<Certificat, String> {

}
