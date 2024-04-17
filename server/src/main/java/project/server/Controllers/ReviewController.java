package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.server.Entities.Review;
import project.server.Services.ReviewService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

	@GetMapping
	public List<Review> getReviews() {
		return service.getReviews();
	}

    @GetMapping(path = "/{id}")
    public Review getReview(@PathVariable("id") int id) {
        return service.getReview(id);
    }

    @PostMapping    
    public Review addReview(@RequestBody Review review) {
        return service.addReview(review);
    }

    @PutMapping
    public Review updateReview(@RequestBody Review review) {
        return service.updateReview(review);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReview(@PathVariable("id") int id) {
        return service.deleteReview(id);
    }

}
