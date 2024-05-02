package project.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.server.Entities.Certification;
import project.server.Entities.Course;
import project.server.Entities.Quizz;
import project.server.Entities.QuizzOption;
import project.server.Entities.QuizzQuestion;
import project.server.Services.CertificationService;
import project.server.Services.QuizzService;
import project.server.Services.UserService;
import project.server.Entities.User;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/certifications")
public class CertificationController {

    private final CertificationService certificationService;
    private final QuizzService quizService;
    private final UserService userService;

    @Autowired
    public CertificationController(CertificationService certificationService, QuizzService quizService, UserService userService) {
        this.certificationService = certificationService;
        this.quizService = quizService;
        this.userService = userService;
    }

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public Certification getCertificationById(@PathVariable int id) {
        return certificationService.getCertificationById(id);
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.saveCertification(certification);
    }

    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable int id) {
        certificationService.deleteCertification(id);
    }

    @PostMapping("/submit-quiz")
    public ResponseEntity<Certification> submitQuiz(@RequestBody Map<String, Object> request) {
    int quizId = (int) request.get("quizId");
    int userId = (int) request.get("userId");
    List<Integer> userAnswers = (List<Integer>) request.get("userAnswers");

    Quizz quiz = quizService.getQuizzById(quizId);

    if (quiz != null) {
        List<QuizzQuestion> questions = quiz.getQuestions();
        int totalQuestions = questions.size();
        int correctAnswersCount = 0;

        for (int i = 0; i < totalQuestions; i++) {
            QuizzQuestion question = questions.get(i);
            List<QuizzOption> options = question.getOptions();
            int correctOptionId = options.stream()
                    .filter(QuizzOption::isCorrect)
                    .findFirst()
                    .map(QuizzOption::getId)
                    .orElse(-1); 

            if (userAnswers.get(i).equals(correctOptionId)) {
                correctAnswersCount++;
            }
        }

        double score = ((double) correctAnswersCount / totalQuestions) * 100;
        boolean eligibleForCertification = (score >= 80); 

        if (eligibleForCertification) {
            User user = userService.getUserById(userId);
            Course course = quiz.getCourse();
            Certification certification = new Certification(user, course, true);
            certificationService.saveCertification(certification);
            return ResponseEntity.ok(certification);
        } else {
            return ResponseEntity.notFound().build();
        }
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
