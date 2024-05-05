package project.server.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import project.server.Entities.Quizz;
import project.server.Entities.QuizzOption;
import project.server.Entities.QuizzQuestion;
import project.server.Entities.DTO.QuizzDto;
import project.server.Entities.Mappers.QuizzMapper;
import project.server.Repositories.QuizzRepo;

@Service
public class QuizzService {

    @Autowired
    private QuizzRepo repo;
    
    public List<Quizz> getAllQuizzes() {
        return repo.findAll();
    }

    public Quizz findById(int id) {
        Optional<Quizz> quizz = repo.findById(id);
        if (quizz.isPresent())
            return quizz.get();
        return null;
    }

    public QuizzDto addQuizz(QuizzDto quizz) {
        Quizz newQuizz = QuizzMapper.convertToEntity(quizz);
        for (QuizzQuestion question : newQuizz.getQuestions()) {
            question.setQuizz(newQuizz);
            for (QuizzOption option : question.getOptions()) {
                option.setQuizzQuestion(question);
            }
        }
        Quizz savedQuizz = repo.save(newQuizz);
        return QuizzMapper.convertToDto(savedQuizz);
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

    public Quizz getQuizzById(int quizId) {
        return repo.findById(quizId).orElse(null);
    }

}
