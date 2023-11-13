package com.example.demo.service;

import com.example.demo.model.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);

    // Read operation
    List<Movie> fetchMovieList();

    // Update operation
    void updateMovie(Movie Movie, Long movieId);

    // Delete operation
    void deleteMovieById(Long movieId);
}
