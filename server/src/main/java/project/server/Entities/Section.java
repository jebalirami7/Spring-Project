package project.server.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import jakarta.persistence.OneToMany;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int niveau;    
    @OneToMany(mappedBy = "section")
    private List<Student> created_students;
    @ManyToMany
    @JoinTable(
        name = "section_subject",
        joinColumns = @JoinColumn(name = "section_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

}