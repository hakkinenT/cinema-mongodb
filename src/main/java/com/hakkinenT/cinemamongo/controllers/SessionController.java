package com.hakkinenT.cinemamongo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hakkinenT.cinemamongo.models.entities.sessions.dto.SessionDTO;
import com.hakkinenT.cinemamongo.services.SessionService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionDTO> insert(@RequestBody SessionDTO dto) {
        dto = sessionService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{exhibitionDate}")
                .buildAndExpand(dto.getExhibitionDate())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }
    
}
