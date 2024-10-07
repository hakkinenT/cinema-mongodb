package com.hakkinenT.cinemamongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.models.entities.movies.Movie;
import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieDTO;
import com.hakkinenT.cinemamongo.repositories.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO findById(String id){
        Movie movie = movieRepository.searchMovieById(id);
        return new MovieDTO(movie, movie.getSessions());
    }
}
