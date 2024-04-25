package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import project.server.Entities.CourseMaterial;
import project.server.Entities.DTO.CourseMaterialDto;
import project.server.Services.CourseMaterialService;

@RestController
@RequestMapping(path = "/lecture/")
public class CourseMaterialController {

    @Autowired
    private  CourseMaterialService courseMaterialService;
    
    @GetMapping
    public ResponseEntity<List<CourseMaterialDto>> getAllCourseMaterials() {
        List<CourseMaterialDto> materials = courseMaterialService.getAllCourseMaterials();
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseMaterialDto> getCourseById(@PathVariable int id) {
        CourseMaterialDto material = courseMaterialService.getCourseMaterialById(id);
        if (material != null) {
            return ResponseEntity.ok(material);
        }
        return ResponseEntity.notFound().build(); // 404
    }


    @PostMapping
    public ResponseEntity<CourseMaterialDto> createCourseMaterial(@RequestBody CourseMaterialDto materialObject) {
        CourseMaterialDto material = courseMaterialService.createCourseMaterial(materialObject);
        if ( material != null) {
            return ResponseEntity.ok(material);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CourseMaterial> updateCourse(@PathVariable int id, @RequestBody CourseMaterial course) {
        CourseMaterial updatedCourse = courseMaterialService.updateCourseMaterial(id, course);
        return ResponseEntity.ok().body(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        courseMaterialService.deleteCourseMaterial(id);
        return ResponseEntity.noContent().build();
    }
}


