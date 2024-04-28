package project.server.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;  
    private String imagePath = "../../assets/images/woman2.jpg";
    private float rating;
    private float duration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private Tutor creator;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<StudentCourse> userCourses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Chapter> chapters;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;

    // @OneToMany(mappedBy = "course")
    // private List<UserCourse> certificats;

}
