package project.server.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.server.Entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
