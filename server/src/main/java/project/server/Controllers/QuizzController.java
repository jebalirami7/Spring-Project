package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.server.Entities.Quizz;
import project.server.Entities.DTO.QuizzDto;
import project.server.Services.QuizzService;

@RestController
@RequestMapping(path = "/quizz")
public class QuizzController {

    @Autowired
    private QuizzService service;

    @GetMapping
    public List<Quizz> getAllQuizzes() {
        return service.getAllQuizzes();
    }

    @GetMapping(path = "/{id}")
    public Quizz getQuizzById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping
    public QuizzDto createQuizz(@RequestBody QuizzDto q) {
        return service.addQuizz(q);
    }

    @PatchMapping
    public Quizz updateQuizz(@RequestBody Quizz q) {
        return service.updateQuizz(q);
    }

    @DeleteMapping(path = "/{id}")
    public Quizz deleteQuizz(@PathVariable("id") int id) {
        return service.deleteQuizz(id);
    }

}
