package project.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.server.Entities.Course;
import project.server.Services.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<List<Course>> getCoursesByTutor(@PathVariable int tutorId) {
        List<Course> courses = courseService.getCoursesByTutor(tutorId);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getCoursesByStudent(@PathVariable int studentId) {
        List<Course> courses = courseService.getCoursesByStudent(studentId);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/bySection/{sectionName}")
    public ResponseEntity<List<Course>> getCoursesBySection(@PathVariable String sectionName) {
        return ResponseEntity.ok(courseService.getCoursesBySection(sectionName));
    }

    @GetMapping("/search/{courseName}")
    public ResponseEntity<List<Course>> getCoursesBycourse(@PathVariable String courseName) {
        return ResponseEntity.ok(courseService.getCoursesByName(courseName));
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Course>> getPopularCourses() {
        return ResponseEntity.ok(courseService.getTop3Courses());
    }

    @PostMapping("/isJoined/{studentId}")
    public ResponseEntity<List<Pair<Boolean, Integer>>> getJoinedCourses(@RequestBody List<Integer> courseIds, @PathVariable int studentId) {
        return ResponseEntity.ok(courseService.existsByCourseIdsAndStudentId(courseIds, studentId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return ResponseEntity.ok().body(updatedCourse);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public Course addStudentToCourse(@PathVariable int courseId, @PathVariable int studentId) {
        return courseService.addStudentToCourse(courseId, studentId);
    }

    @PutMapping("/{courseId}/tutor/{tutorId}")
    public Course assignTutorToCourse(@PathVariable int courseId, @PathVariable int tutorId) {
        return courseService.assignTutorToCourse(courseId, tutorId);
    }

}

