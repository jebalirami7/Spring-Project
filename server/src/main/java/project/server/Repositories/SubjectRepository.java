package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.server.Entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    // You can define custom query methods here if needed
}
