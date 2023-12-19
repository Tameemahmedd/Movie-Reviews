package com.moviereview.moviereviewproject.service;

import com.moviereview.moviereviewproject.domain.Movie;
import com.moviereview.moviereviewproject.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private MovieRepository movieRepository;
    public AdminService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public Movie addMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

}
