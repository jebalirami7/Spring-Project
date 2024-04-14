package project.server.commentaires_et_retours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireService {
    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public List<Commentaire> getCo() {
        return commentaireRepository.findAll();
    }

    public void createCommentaire(Commentaire commentaire) {
        System.out.println(commentaire);
        commentaireRepository.save(commentaire);
        // throw new UnsupportedOperationException("Unimplemented method 'createTuteur'");
    }
}