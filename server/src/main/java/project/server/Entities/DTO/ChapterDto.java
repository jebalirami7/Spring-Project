package project.server.Entities.DTO;

import java.util.List;

import lombok.Data;

@Data
public class ChapterDto 
{
    private int id;
    private String title ;
    private int courseId  ;
    private List<CourseMaterialDto> courseMaterials;
}
