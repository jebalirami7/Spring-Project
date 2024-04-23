package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.server.Entities.Course;
import project.server.Repositories.CourseRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepo.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course updateCourse(int id, Course updatedCourse) {
        if (courseRepo.existsById(id)) {
            updatedCourse.setId(id);
            return courseRepo.save(updatedCourse);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }

    public void deleteCourse(int id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }
}
