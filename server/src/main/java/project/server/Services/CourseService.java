package project.server.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Course;
import project.server.Repositories.CourseRepo;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepo repo;

    public List<Course> getCourses() {
        return repo.findAll();
    }

    public Course getCourse(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public Course updateCourse(Course course) {
        boolean exists = repo.existsById(course.getId());
        if (!exists) 
            throw new IllegalStateException("Course with id " + course.getId() + " does not exist");
        return repo.save(course);
    }

    public String deleteCourse(int id) {
        boolean exists = repo.existsById(id);
        if (!exists) 
            throw new IllegalStateException("Course with id " + id + " does not exist");
        repo.deleteById(id);
        return "Course with id " + id + " was successfully deleted";
    }

}
