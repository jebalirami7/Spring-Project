package project.server.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.server.Entities.Chapter;
import project.server.Entities.Course;
import project.server.Entities.DTO.ChapterDto;
import project.server.Entities.Mappers.ChapterMapper;
import project.server.Repositories.ChapterRepo;
import project.server.Repositories.CourseRepo;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepo chapterRepo;
    @Autowired
    private CourseRepo  courseRepo;

    public List<ChapterDto> getAllChapters() {
        List<Chapter> chapters =  chapterRepo.findAll();
        return chapters.stream().map(ChapterMapper::convertToDto).toList();
    }

    public ChapterDto getChapterById(int id) {
        return ChapterMapper.convertToDto(chapterRepo.findById(id).orElse(null));
    }

    public ChapterDto createChapter(ChapterDto chapter) {
        Chapter newChapter = ChapterMapper.convertToEntity(chapter);
        Course course = courseRepo.findById(chapter.getCourseId()).orElse(null);
        if ( course != null) {
            newChapter.setCourse(course);
            return ChapterMapper.convertToDto(chapterRepo.save(newChapter));
        }
        return null ; 
    }

    public Chapter updateChapter(int id, Chapter updatedChapter) {
        if (chapterRepo.existsById(id)) {
            updatedChapter.setId(id);
            return chapterRepo.save(updatedChapter);
        } else {
            throw new RuntimeException("Material not found with id: " + id);
        }
    }

    public void deleteChapter(int id) {
        if (chapterRepo.existsById(id)) {
            chapterRepo.deleteById(id);
        } else {
            throw new RuntimeException("Course not found with id: " + id);
        }
    }

    public List<ChapterDto> getAllChaptersByCourse(int id) {
        Course course = courseRepo.findById(id).orElse(null);
        if (course != null) {
            List<Chapter> chapters = chapterRepo.findByCourse(course);
            return chapters.stream().map(ChapterMapper::convertToDto).toList();
        }
        return null;
    }


}
