package project.server.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepo repo;

    public List<Review> getReviews() {
        return repo.findAll();
    }

    public Review getReview(int id) {
        boolean exists = repo.existsById(id);
        if (!exists) 
            throw new IllegalStateException("Review with id " + id + " does not exist");
        return repo.findById(id).orElse(null);
    }

    public Review addReview(Review review) {
        return repo.save(review);
    }

    public Review updateReview(Review review) {
        return repo.findById(review.getId())
            .map(existingReview -> {
                if (review.getComment() != null) {
                    existingReview.setComment(review.getComment());
                }
                if (review.getRating() != 0) {
                    existingReview.setRating(review.getRating());
                }
                return repo.save(existingReview);
            })
            .orElseThrow(() -> new IllegalStateException("Review with id " + review.getId() + " does not exist"));
    }

    public String deleteReview(int id) {
        boolean exists = repo.existsById(id);
        if (!exists) 
            throw new IllegalStateException("Review with id " + id + " does not exist");
        repo.deleteById(id);
        return "Review with id " + id + " was successfully deleted";
    }

}
