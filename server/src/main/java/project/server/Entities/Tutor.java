package project.server.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Tutor extends User {

    private String expertise;
    
    // Additional properties and methods specific to Tutor

}
