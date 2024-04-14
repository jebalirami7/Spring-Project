package project.server.tuteur;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table
public class Tuteur {

    @Id
    @SequenceGenerator(
        name = "tuteur_sequence", 
        sequenceName = "tuteur_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "tuteur_sequence"
    )
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Tuteur() {
    }

    public Tuteur(int id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Tuteur(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tuteur [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + "]";
    }
}
