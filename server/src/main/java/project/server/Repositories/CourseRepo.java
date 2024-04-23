package project.server.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.server.Entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findBySubjectName(String subjectName);

}
