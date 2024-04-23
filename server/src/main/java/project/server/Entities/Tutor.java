package project.server.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
public class Tutor extends User {
    private String username="abc";
    private String expertise;
    @OneToMany(mappedBy = "creator")
    private List<Course> created_courses;
}