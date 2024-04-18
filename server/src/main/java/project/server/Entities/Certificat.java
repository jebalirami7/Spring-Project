package project.server.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate date;
    private float score;

}
