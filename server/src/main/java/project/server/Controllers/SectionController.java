package project.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.server.Entities.Section;
import project.server.Services.SectionService;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sections = sectionService.getAllSections();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable("id") int id) {
        Section section = sectionService.getSectionById(id);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Section> addSection(@RequestBody Section section) {
        Section addedSection = sectionService.addSection(section);
        return new ResponseEntity<>(addedSection, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable("id") int id, @RequestBody Section section) {
        Section updatedSection = sectionService.updateSection(id, section);
        return new ResponseEntity<>(updatedSection, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable("id") int id) {
        sectionService.deleteSection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
