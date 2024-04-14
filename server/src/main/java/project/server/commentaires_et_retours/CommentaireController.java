package project.server.commentaires_et_retours;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RestController
@RequestMapping(path = "api/commentaire")
public class CommentaireController {
    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping
    public List<Commentaire> getCommentaires() {
        return commentaireService.getCo();
    }

    @PostMapping
    public void createCommentaire(@RequestBody Commentaire commentaire) {
        commentaireService.createCommentaire(commentaire);
    }
}
