package project.server.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quizz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String[] questions;
    private int[] reponses;
    private String[][] options;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

}
