package com.moviereview.moviereviewproject.controller;

import com.moviereview.moviereviewproject.domain.Review;
import com.moviereview.moviereviewproject.service.ReviewService;
import com.moviereview.moviereviewproject.service.request.ReviewRequest;
import com.moviereview.moviereviewproject.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }
@GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
