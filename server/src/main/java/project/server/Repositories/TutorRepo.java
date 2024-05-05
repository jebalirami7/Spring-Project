package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.server.Entities.Tutor;

@Repository
public interface TutorRepo extends JpaRepository<Tutor, Integer> {
    // Add any specific query methods for Tutor if needed
}