package com.hakkinenT.cinemamongo.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hakkinenT.cinemamongo.models.entities.rooms.dto.ScreeningRoomDTO;
import com.hakkinenT.cinemamongo.services.ScreeningRoomService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/rooms")
public class ScreeningRoomController {
    @Autowired
    public ScreeningRoomService roomService;

    @GetMapping("/{roomNumber}")
    public ResponseEntity<ScreeningRoomDTO> findById(@PathVariable Integer roomNumber) {
        ScreeningRoomDTO room = roomService.findById(roomNumber);
        return ResponseEntity.ok(room);
    }
    
    @PostMapping
    public ResponseEntity<ScreeningRoomDTO> insert(@RequestBody ScreeningRoomDTO dto) {
        dto = roomService.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{roomNumber}")
                .buildAndExpand(dto.getRoomNumber())
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> delete(@PathVariable Integer roomNumber){
        roomService.delete(roomNumber);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{roomNumber}")
    public ResponseEntity<ScreeningRoomDTO> update(@PathVariable Integer roomNumber, @RequestBody ScreeningRoomDTO dto){
        ScreeningRoomDTO room = roomService.update(roomNumber, dto);
        return ResponseEntity.ok(room);
    }
}
