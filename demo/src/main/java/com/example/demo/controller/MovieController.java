package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    // Save operation
    @PostMapping("/movies")
    public Movie saveMovies(@RequestBody Movie movie)
    {
        return movieService.saveMovie(movie);
    }

    // Read operation
    @GetMapping("/movies")
    public String displayMovieList(Model model) {
        List<Movie> movies = movieService.fetchMovieList(); // Fetch the list of movies from your service
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovie(@PathVariable("id") Long movieId, Model model) {
        Movie movie = (Movie) movieService.fetchMovieList().stream().filter(mov-> movieId.equals(mov.getId())).findAny().orElse(null);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    // Update operation
    @PutMapping("/movies/edit/{id}")
    public String
    updateMovie(@RequestBody Movie movie,
                     @PathVariable("id") Long movieId)
    {
        movieService.updateMovie(movie, movieId);
        return "redirect:/movies";
    }

    @PostMapping("/movies/delete/{id}")
    public String deleteMovieById(@PathVariable("id")
                                       Long departmentId)
    {
        movieService.deleteMovieById(departmentId);
        return "movies";
    }
}
