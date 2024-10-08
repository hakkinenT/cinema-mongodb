package com.hakkinenT.cinemamongo.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieDTO;
import com.hakkinenT.cinemamongo.models.entities.movies.dto.MovieMinDTO;
import com.hakkinenT.cinemamongo.services.MovieService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    
    @PostMapping
    public ResponseEntity<MovieMinDTO> insert(@RequestBody MovieMinDTO dto) {
        dto = movieService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MovieMinDTO> update(@PathVariable String id, @RequestBody MovieMinDTO dto){
        MovieMinDTO movie = movieService.update(id, dto);
        return ResponseEntity.ok(movie);
    }
}
