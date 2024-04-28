package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import project.server.Entities.Course;
import project.server.Entities.Student;
import project.server.Entities.StudentCourse;
import project.server.Entities.Tutor;
import project.server.Repositories.CourseRepo;
import project.server.Repositories.StudentCourseRepo;
import project.server.Repositories.StudentRepo;
import project.server.Repositories.TutorRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TutorRepo tutorRepo;
    @Autowired
    private StudentCourseRepo studentCourseRepo;

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

    public Course addStudentToCourse(int courseId, int studentId) {
        Course course = courseRepo.findById(courseId).get();
        Student student = studentRepo.findById(studentId).get();
        
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourse(course);
        studentCourse.setStudent(student);
        studentCourse.setDate(LocalDate.now().toString());

        studentCourseRepo.save(studentCourse);
        return courseRepo.save(course);
    }

    public Course assignTutorToCourse(int courseId, int tutorId) {
        Course course = courseRepo.findById(courseId).get();
        Tutor tutor = tutorRepo.findById(tutorId).get();

        course.setCreator(tutor);
        return courseRepo.save(course);    
    }

    public List<Course> getCoursesByTutor(int tutorId) {
        Tutor tutor = tutorRepo.findById(tutorId).get();
        return courseRepo.findByCreator(tutor);  
    }

    public List<Course> getCoursesByStudent(int studentId) {
        Student student = studentRepo.findById(studentId).get();
        return courseRepo.findByStudent(student);  
    }

    public List<Course> getCoursesBySection(String subjectName) {
        if (subjectName.equals("All")) {
            return courseRepo.findAll();
        }
        return courseRepo.findBySectionNameIgnoreCase(subjectName);
    }

    public List<Course> getCoursesByName(String courseName) {
        return courseRepo.findByNameContainingIgnoreCase(courseName);
    }

    public List<Course> getTop3Courses() {
        return courseRepo.findTop3ByOrderByRatingDesc();
    }

    public List<Pair<Boolean, Integer>> existsByCourseIdsAndStudentId(List<Integer> courseIds, int studentId) {
        List<Pair<Boolean, Integer>> existsList = new ArrayList<>();
        for (Integer courseId : courseIds) {
            existsList.add(
                Pair.of(
                    studentCourseRepo.existsByCourseIdAndStudentId(courseId, studentId),
                    studentCourseRepo.countByCourseId(courseId)
                )
            );
        }
        return existsList;
    }

}
