package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.server.Entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
