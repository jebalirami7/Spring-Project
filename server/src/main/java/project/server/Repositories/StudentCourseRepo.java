package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.server.Entities.StudentCourse;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse, Integer> {

}
