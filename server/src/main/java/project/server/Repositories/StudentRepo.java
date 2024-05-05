package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.server.Entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    // Add any specific query methods for Student if needed
}