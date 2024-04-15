package project.server.quizz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuizzService {
    
    @Autowired
    private QuizzRepo repo ;


    public Quizz findById(String id){
        Optional<Quizz> quizz = repo.findById(id);
        if (quizz.isPresent())
            return  quizz.get();
        else 
            return null ;
    }


    public Quizz addQuizz(Quizz q) {
        return repo.save(q);
    }

    public Quizz updateQuizz(Quizz q) {
        return repo.save(q);
    }


    public Quizz deleteQuizz(Quizz q ) {
        repo.delete(q);
        return q ;
    }


}
