package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.server.Entities.Subject;
import project.server.Repositories.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(int id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(int id, Subject updatedSubject) {
        updatedSubject.setId(id); // Ensure the ID is set
        return subjectRepository.save(updatedSubject);
    }

    public void deleteSubject(int id) {
        subjectRepository.deleteById(id);
    }
}
