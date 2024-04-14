package project.server.tuteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuteurRepository extends JpaRepository<Tuteur, Integer>{

}
