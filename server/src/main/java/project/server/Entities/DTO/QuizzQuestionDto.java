package project.server.Entities.DTO;

import java.util.List;

import lombok.Data;

@Data
public class QuizzQuestionDto {
    
    private int id;
    private String question;
    private List<QuizzOptionDto> options;

}
