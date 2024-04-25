package org.jobapp.reviewms.review;

import org.jobapp.reviewms.review.ReviewServiceImpl.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error adding review", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewsById(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviews(@PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(reviewId, review);
        if (isReviewUpdated) {
        return new ResponseEntity<>("Review updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error updating review", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewService.deletedReviewById(reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error deleting review", HttpStatus.NOT_FOUND);
        }
    }
}
