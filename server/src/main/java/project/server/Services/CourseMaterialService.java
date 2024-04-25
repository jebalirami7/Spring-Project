package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.Chapter;
import project.server.Entities.CourseMaterial;
import project.server.Entities.DTO.CourseMaterialDto;
import project.server.Entities.Mappers.CourseMaterialMapper;
import project.server.Repositories.ChapterRepo;
import project.server.Repositories.CourseMaterialRepo;

import java.util.List;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepo courseMaterialRepo;
    @Autowired
    private ChapterRepo chapterRepo;

    public List<CourseMaterialDto> getAllCourseMaterials() {
        List<CourseMaterial>  materials = courseMaterialRepo.findAll();
        return materials.stream().map(CourseMaterialMapper::convertToDto).toList();
    }

    public CourseMaterialDto getCourseMaterialById(int id) {
        return CourseMaterialMapper.convertToDto(courseMaterialRepo.findById(id).orElse(null));
    }

    public CourseMaterialDto createCourseMaterial(CourseMaterialDto material) {
        CourseMaterial newMaterial = CourseMaterialMapper.convertToEntity(material);
        Chapter chapter = chapterRepo.findById(material.getChapterId()).orElse(null);
        if ( chapter != null) {
            newMaterial.setChapter(chapter);
            return CourseMaterialMapper.convertToDto(courseMaterialRepo.save(newMaterial));
        }
        return null;
    }

    public CourseMaterial updateCourseMaterial(int id, CourseMaterial updatedMaterial) {
        if (courseMaterialRepo.existsById(id)) {
            updatedMaterial.setId(id);
            return courseMaterialRepo.save(updatedMaterial);
        } else {
            throw new RuntimeException("Material not found with id: " + id);
        }
    }

    public void deleteCourseMaterial(int id) {
        if (courseMaterialRepo.existsById(id)) {
            courseMaterialRepo.deleteById(id);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }


}
