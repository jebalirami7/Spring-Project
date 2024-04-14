package project.server.tuteur;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/tuteur")
public class TuteurController {

    private final TuteurService tuteurService;

    public TuteurController(TuteurService tuteurService) {
        this.tuteurService = tuteurService;
    }

	@GetMapping
	public List<Tuteur> getTuteurs() {
		return tuteurService.getTuteurs();
	}

    @PostMapping    
    public void createTuteur(@RequestBody Tuteur tuteur) {
        tuteurService.createTuteur(tuteur);
    }

}
