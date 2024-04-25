package project.server.Entities.DTO;

import lombok.Data;

@Data
public class CourseMaterialDto 
{
    private int id;
    private String title;
    private String content;
    private String type;

    private int chapterId;
}
