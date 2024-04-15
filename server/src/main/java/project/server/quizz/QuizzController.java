package project.server.quizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/quizz")
public class QuizzController {

    @Autowired
    private QuizzService service ;

    @GetMapping("/{id}")
    public Quizz getQuizzById(@RequestParam(value = "id") String id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public Quizz createQuizz(@RequestBody()  Quizz q ) {
        return service.addQuizz(q);
    }

    @PatchMapping("/{id}")
    public Quizz updateQuizz(@RequestParam(value = "id")String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public Quizz deleteQuizz(@RequestParam(value = "id")String id) {
        return service.findById(id);
    }
}
