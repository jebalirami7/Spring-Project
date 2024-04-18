package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import project.server.Entities.Course;
import project.server.Services.CourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> getCourses() {
        return service.getCourses();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(int id) {
        return service.getCourse(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        System.out.println(course);
        return service.addCourse(course);
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        return service.deleteCourse(id);
    }
    
}
