package com.hakkinenT.cinemamongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieDTO;
import com.hakkinenT.cinemamongo.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    public MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable String id) {
        MovieDTO movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }
    

}
