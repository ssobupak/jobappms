package org.jobapp.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review getReviewsById(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

    boolean deletedReviewById(Long reviewId);
}
