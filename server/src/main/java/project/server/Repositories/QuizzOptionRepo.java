package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.server.Entities.QuizzOption;

@Repository
public interface QuizzOptionRepo extends JpaRepository<QuizzOption, Integer> {

}
