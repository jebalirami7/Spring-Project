package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.server.Entities.Tutor;
import project.server.Services.TutorService;

@RestController
@RequestMapping(path = "/tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public List<Tutor> getTutors() {
        return tutorService.getTutors();
    }

    @GetMapping(path = "{id}")
    public Tutor getTutor(@PathVariable("id") int id) {
        return tutorService.getTutor(id);
    }

    @PostMapping    
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    @DeleteMapping(path = "{id}")
    public String deleteTutor(@PathVariable("id") int id) {
        return tutorService.deleteTutor(id);
    }

}
