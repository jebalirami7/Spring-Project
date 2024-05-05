package project.server.Services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.util.Pair;

import project.server.Entities.Course;
import project.server.Entities.Tutor;
import project.server.Repositories.CourseRepo;
import project.server.Repositories.StudentCourseRepo;
import project.server.Repositories.StudentRepo;
import project.server.Repositories.TutorRepo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CourseServiceTest {

    CourseRepo courseRepo = Mockito.mock(CourseRepo.class);
    StudentRepo studentRepo = Mockito.mock(StudentRepo.class);
    StudentCourseRepo studentCourseRepo = Mockito.mock(StudentCourseRepo.class);
    TutorRepo tutorRepo = Mockito.mock(TutorRepo.class);

    CourseService courseService = new CourseService(courseRepo, studentRepo, tutorRepo, studentCourseRepo);

    @Test
    public void testCreateCourse() {
        Course course = new Course();
        when(courseRepo.save(course)).thenReturn(course);
        assertEquals(course, courseService.createCourse(course));
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        course.setId(1);
        when(courseRepo.existsById(1)).thenReturn(true);
        when(courseRepo.save(course)).thenReturn(course);
        assertEquals(course, courseService.updateCourse(1, course));
    }

    @Test
    public void testDeleteCourse() {
        when(courseRepo.existsById(1)).thenReturn(true);
        doNothing().when(courseRepo).deleteById(1);
        assertDoesNotThrow(() -> courseService.deleteCourse(1));
    }

    @Test
    public void testGetCoursesByTutor() {
        Tutor tutor = new Tutor();
        List<Course> courses = new ArrayList<>();
        when(tutorRepo.findById(1)).thenReturn(Optional.of(tutor));
        when(courseRepo.findByCreator(tutor)).thenReturn(courses);
        assertEquals(courses, courseService.getCoursesByTutor(1));
    }

    @Test
    public void testGetCoursesBySection() {
        List<Course> courses = new ArrayList<>();
        when(courseRepo.findAll()).thenReturn(courses);
        assertEquals(courses, courseService.getCoursesBySection("All"));
    }

    @Test
    public void testExistsByCourseIdsAndStudentId() {
        List<Integer> courseIds = Arrays.asList(1, 2, 3);
        int studentId = 1;
        when(studentCourseRepo.existsByCourseIdAndStudentId(1, studentId)).thenReturn(true);
        when(studentCourseRepo.existsByCourseIdAndStudentId(2, studentId)).thenReturn(false);
        when(studentCourseRepo.existsByCourseIdAndStudentId(3, studentId)).thenReturn(true);
        when(studentCourseRepo.countByCourseId(1)).thenReturn(10);
        when(studentCourseRepo.countByCourseId(2)).thenReturn(20);
        when(studentCourseRepo.countByCourseId(3)).thenReturn(30);
        List<Pair<Boolean, Integer>> expected = Arrays.asList(
            Pair.of(true, 10),
            Pair.of(false, 20),
            Pair.of(true, 30)
        );
        assertEquals(expected, courseService.existsByCourseIdsAndStudentId(courseIds, studentId));
    }

}
