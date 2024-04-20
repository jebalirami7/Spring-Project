package project.server.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Student;
import project.server.Repositories.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student getStudent(int userIdId) {
        return studentRepo.findById(userIdId).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public String deleteStudent(int userId) {
        boolean exists = studentRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + userId + " does not exist");
        }
        studentRepo.deleteById(userId);
        return "Student with id " + userId + " was successfully deleted";
    }
}
