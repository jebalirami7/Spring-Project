package project.server.Entities.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CourseMaterialDto 
{
    private int id;
    private String title;
    private String content;
    private String type;

    private int chapterId;
}
