package project.server.certificat;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Certificat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id ;
    private Date date ; 
    private float score ;

    

}