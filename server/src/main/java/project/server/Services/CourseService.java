package project.server.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Course;
import project.server.Repositories.CourseRepo;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepo courseRepo;
    // @Autowired
    // private UserService userService;


    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    public Course getCourse(int id) {
        return courseRepo.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        // course.setCreator(userService.getUser(course.getCreator().getId()));
        return courseRepo.save(course);
    }

    public Course updateCourse(Course course) {
        boolean exists = courseRepo.existsById(course.getId());
        if (!exists) 
            throw new IllegalStateException("Course with id " + course.getId() + " does not exist");
        return courseRepo.save(course);
    }

    public String deleteCourse(int id) {
        boolean exists = courseRepo.existsById(id);
        if (!exists) 
            throw new IllegalStateException("Course with id " + id + " does not exist");
        courseRepo.deleteById(id);
        return "Course with id " + id + " was successfully deleted";
    }

}
