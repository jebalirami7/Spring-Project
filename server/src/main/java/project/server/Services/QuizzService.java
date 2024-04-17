package project.server.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Quizz;
import project.server.Repositories.QuizzRepo;

@Service
public class QuizzService {

    @Autowired
    private QuizzRepo repo;

    public Quizz findById(int id) {
        Optional<Quizz> quizz = repo.findById(id);
        if (quizz.isPresent())
            return quizz.get();
        return null;
    }

    public Quizz addQuizz(Quizz q) {
        return repo.save(q);
    }

    public Quizz updateQuizz(Quizz q) {
        Optional<Quizz> quizz = repo.findById(q.getId());
        if (!quizz.isPresent())
            throw new IllegalStateException("Quizz with id " + q.getId() + " does not exist");
        return repo.save(q);
    }

    public Quizz deleteQuizz(int id) {
        Optional<Quizz> quizz = repo.findById(id);
        if (!quizz.isPresent())
            throw new IllegalStateException("Quizz with id " + id + " does not exist");
        repo.delete(quizz.get());
        return quizz.get();
    }

}
