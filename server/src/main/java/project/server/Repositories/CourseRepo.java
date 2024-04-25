package project.server.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.server.Entities.Course;
import project.server.Entities.Student;
import project.server.Entities.Tutor;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findBySubjectName(String subjectName);

    List<Course> findByCreator(Tutor creator);

    @Query("SELECT c FROM Course c JOIN c.userCourses uc WHERE uc.student = :student")
    List<Course> findByStudent(Student student);

}
