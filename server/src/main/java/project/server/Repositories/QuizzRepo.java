package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.server.Entities.Quizz;

@Repository
public interface QuizzRepo extends JpaRepository<Quizz, Integer> {

}
