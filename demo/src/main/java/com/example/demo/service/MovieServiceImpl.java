package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> fetchMovieList() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public void updateMovie(Movie movie, Long movieId) {
        Movie DB = movieRepository.findById(movieId).get();
        if (Objects.nonNull(movie.getTitle())
                && !"".equalsIgnoreCase(
                movie.getTitle())) {
            DB.setTitle(
                    movie.getTitle());
        }
        if (Objects.nonNull(movie.getSummary())
                && !"".equalsIgnoreCase(
                movie.getSummary())) {
            DB.setSummary(
                    movie.getSummary());
        }
            DB.setRating(movie.getRating());

        movieRepository.save(DB);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
