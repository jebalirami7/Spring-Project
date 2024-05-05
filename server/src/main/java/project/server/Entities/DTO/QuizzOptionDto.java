package project.server.Entities.DTO;


import lombok.Data;

@Data
public class QuizzOptionDto {
    
    private int id;
    private String option;
    private boolean correct;
    
}
