package project.server.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

    private Section section;
    private String major;
    
    // Additional properties and methods specific to Student

}
