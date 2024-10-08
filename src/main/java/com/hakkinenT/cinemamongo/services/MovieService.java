package com.hakkinenT.cinemamongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinemamongo.models.entities.movies.Movie;
import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieDTO;
import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieMinDTO;
import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Actor;
import com.hakkinenT.cinemamongo.models.entities.movies.embedded.Gender;
import com.hakkinenT.cinemamongo.repositories.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO findById(String id){
        if(!movieRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

        Movie movie = movieRepository.searchMovieById(id);
        return new MovieDTO(movie, movie.getSessions());
    }

    public MovieMinDTO insert(MovieMinDTO dto){
        Movie movie = new Movie();
        createMovie(dto, movie);

        movie = movieRepository.insert(movie);

        return new MovieMinDTO(movie);
    }

    private void createMovie(MovieMinDTO dto, Movie movie) {
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setDuration(dto.getDuration());
        movie.setImageUrl(dto.getImageUrl());
        movie.setSynopsis(dto.getSynopsis());
        movie.setAgeRating(dto.getAgeRating());

        addGenders(dto, movie);
        addActors(dto, movie);
    }

    private void addActors(MovieMinDTO dto, Movie movie) {
        movie.getActors().clear();
        for(Actor actor : dto.getActors()){
            movie.addActors(actor);
        }
    }

    private void addGenders(MovieMinDTO dto, Movie movie) {
        movie.getGenders().clear();
        for(Gender gender : dto.getGenders()){
            movie.addGender(gender);
        }
    }

    public MovieMinDTO update(String id, MovieMinDTO dto){
        Movie movie = getMovieById(id);
        createMovie(dto, movie);
        
        movie = movieRepository.save(movie);
        return new MovieMinDTO(movie);
    }

    private Movie getMovieById(String id){
        return movieRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    public void delete(String movieId){
        if(!movieRepository.existsById(movieId)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        movieRepository.deleteById(movieId);
    }

}
