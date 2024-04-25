package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.server.Entities.QuizzQuestion;

@Repository
public interface QuizzQuestionRepo extends JpaRepository<QuizzQuestion, Integer> {

}
