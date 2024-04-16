package project.server.certificat;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private LocalDate date;
    private float score;

}
