package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.server.Entities.Certificat;

@Repository
public interface CertificatRepo extends JpaRepository<Certificat, Integer> {

}
