package project.server.Entities.DTO;

import java.util.List;

import lombok.Data;

@Data
public class QuizzDto {
    
    private int id;
    private List<QuizzQuestionDto> questions;

}
