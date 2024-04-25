package project.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.server.Entities.Chapter;
import project.server.Entities.DTO.ChapterDto;
import project.server.Services.ChapterService;


import java.util.List;

@RestController
@RequestMapping(path = "/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
    @GetMapping
    public ResponseEntity<List<ChapterDto>> getAllChapters() {
        List<ChapterDto> chapters = chapterService.getAllChapters();
        return ResponseEntity.ok(chapters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterDto> getChapterById(@PathVariable int id) {
        ChapterDto chapter = chapterService.getChapterById(id);
        if (chapter != null) {
            return ResponseEntity.ok(chapter);
        }
        return ResponseEntity.notFound().build(); // 404
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<ChapterDto>> getAllChaptersByCourse(@PathVariable int id) {
        List<ChapterDto> chapters = chapterService.getAllChaptersByCourse(id);
        return ResponseEntity.ok(chapters);
    }

    @PostMapping
    public ResponseEntity<ChapterDto> createChapter(@RequestBody ChapterDto chapter) {
        ChapterDto createdChapter = chapterService.createChapter(chapter);
        if (createdChapter != null) {
            return ResponseEntity.ok(createdChapter);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Chapter> updateChapter(@PathVariable int id, @RequestBody Chapter chapter) {
        Chapter updatedChapter = chapterService.updateChapter(id, chapter);
        return ResponseEntity.ok().body(updatedChapter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable int id) {
        chapterService.deleteChapter(id);
        return ResponseEntity.noContent().build();
    }
}

