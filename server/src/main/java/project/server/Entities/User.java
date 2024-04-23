package project.server.Entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private LocalDate dob;
    private String password;
    private String role;
    @Transient
    private int age;
    @OneToMany(mappedBy = "user")
    private List<UserCourse> userCourses;
    @OneToMany(mappedBy = "user")
    private List<Review> reviewedCourses;
    @OneToMany(mappedBy = "creator")
    private List<Course> created_courses;
    // @ManyToMany(mappedBy = "users")
    // private List<Course> courses;
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    
}