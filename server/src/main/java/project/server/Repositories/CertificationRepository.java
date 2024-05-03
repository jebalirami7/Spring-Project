package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.server.Entities.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Integer> {
    
}
