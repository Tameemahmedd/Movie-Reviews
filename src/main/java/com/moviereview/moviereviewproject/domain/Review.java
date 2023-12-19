package com.moviereview.moviereviewproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviereview.moviereviewproject.service.response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="review_table")
@ToString
public class Review {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String movieReview;
    private double rating;
    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    @JsonIgnore
    private Movie movie;
@CreationTimestamp
    private Date createdDate;
@UpdateTimestamp
private Date updatedDate;

public static ReviewResponse toReviewResponse(Review review){
    return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
}
public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
    if(Objects.isNull(reviewList))
        return new ArrayList<>();
    else{
        return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}

}
