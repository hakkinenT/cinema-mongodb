package com.hakkinenT.cinemamongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinemamongo.models.entities.rooms.dto.ScreeningRoomDTO;
import com.hakkinenT.cinemamongo.models.entities.rooms.embedded.Seat;
import com.hakkinenT.cinemamongo.repositories.ScreeningRoomRepository;

import com.hakkinenT.cinemamongo.models.entities.rooms.ScreeningRoom;

@Service
public class ScreeningRoomService {
    @Autowired
    private ScreeningRoomRepository roomRepository;

    public ScreeningRoomDTO findById(int roomNumber){
        if(!roomRepository.existsById(roomNumber)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

        ScreeningRoom room = getRoomById(roomNumber);
        
        return new ScreeningRoomDTO(room);
    }

    public ScreeningRoomDTO insert(ScreeningRoomDTO dto){
        ScreeningRoom room = new ScreeningRoom();
        createRoom(dto, room);

        room = roomRepository.insert(room);
        return new ScreeningRoomDTO(room);
    }

    private void createRoom(ScreeningRoomDTO dto, ScreeningRoom room) {
        room.setId(dto.getRoomNumber());
        room.setCapacity(dto.getCapacity());

        addSeats(dto, room);
    }

    private void addSeats(ScreeningRoomDTO dto, ScreeningRoom room) {
        room.getSeats().clear();
        for(Seat seat : dto.getSeats()){
            room.addSeat(seat);
        }
    }

    public ScreeningRoomDTO update(Integer roomNumber, ScreeningRoomDTO dto){
        ScreeningRoom room = getRoomById(roomNumber);
        createRoom(dto, room);
        
        room = roomRepository.save(room);
        return new ScreeningRoomDTO(room);
    }

    private ScreeningRoom getRoomById(Integer roomNumber){
        return roomRepository
            .findById(roomNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    public void delete(Integer roomNumber){
        if(!roomRepository.existsById(roomNumber)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        roomRepository.deleteById(roomNumber);
    }

}
