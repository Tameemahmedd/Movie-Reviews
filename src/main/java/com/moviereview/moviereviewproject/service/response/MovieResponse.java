package com.moviereview.moviereviewproject.service.response;

import com.moviereview.moviereviewproject.domain.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private String title;
    private Genre genre;
    private  Double rating;
    private List<ReviewResponse>reviews;

}
