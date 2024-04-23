package project.server.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Tutor;
import project.server.Repositories.TutorRepo;

@Service
public class TutorService {

    @Autowired
    private TutorRepo tutorRepo;

    public List<Tutor> getTutors() {
        return tutorRepo.findAll();
    }

    public Tutor getTutor(int tutorId) {
        return tutorRepo.findById(tutorId).orElse(null);
    }

    public Tutor createTutor(Tutor tutor) {
        return tutorRepo.save(tutor);
    }

    public String deleteTutor(int tutorId) {
        boolean exists = tutorRepo.existsById(tutorId);
        if (!exists) {
            throw new IllegalStateException("Tutor with id " + tutorId + " does not exist");
        }
        tutorRepo.deleteById(tutorId);
        return "Tutor with id " + tutorId + " was successfully deleted";
    }
}
