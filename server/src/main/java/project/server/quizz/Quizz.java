package project.server.quizz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String question;
    private String[] reponses;

}
