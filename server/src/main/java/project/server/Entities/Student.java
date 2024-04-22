package project.server.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    


}
