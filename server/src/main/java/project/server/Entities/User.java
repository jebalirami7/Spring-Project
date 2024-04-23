package project.server.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username ;
    @Column(nullable = false, unique = true)
    private String password;
    private String role;


    @OneToMany(mappedBy = "creator")
    private List<Course> created_courses;
    
    @OneToMany(mappedBy = "user")
    private List<Review> reviewedCourses;

    @OneToMany(mappedBy = "user")
    private List<UserCourse> userCourses;
    
    // @ManyToMany(mappedBy = "users")
    // private List<Course> courses;


    
}