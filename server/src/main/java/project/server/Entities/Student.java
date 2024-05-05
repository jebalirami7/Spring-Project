package project.server.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    private Section section;
    
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourses;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviewedCourses;

}
