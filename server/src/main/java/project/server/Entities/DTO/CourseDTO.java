package project.server.Entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {
    
    private String name;
    private String description;   
    private Long subject ;
    private Long creator ;
    
}
