package project.server.tuteur;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TuteurService {

	private final TuteurRepository tuteurRepository;

	public TuteurService(TuteurRepository tuteurRepository) {
		this.tuteurRepository = tuteurRepository;
	}

    public List<Tuteur> getTuteurs() {
		return tuteurRepository.findAll();
	}

    public void createTuteur(Tuteur tuteur) {
		System.out.println(tuteur);
		tuteurRepository.save(tuteur);
        // throw new UnsupportedOperationException("Unimplemented method 'createTuteur'");
    }

}
