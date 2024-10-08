package com.hakkinenT.cinemamongo.models.entities.rooms.dto;

import java.util.ArrayList;
import java.util.List;

import com.hakkinenT.cinemamongo.models.entities.rooms.ScreeningRoom;
import com.hakkinenT.cinemamongo.models.entities.rooms.embedded.Seat;

public class ScreeningRoomDTO {
    private Integer roomNumber;
    private Integer capacity;
    private List<Seat> seats = new ArrayList<>();

    public ScreeningRoomDTO() {
    }

    public ScreeningRoomDTO(Integer roomNumber, Integer capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public ScreeningRoomDTO(ScreeningRoom entity) {
        this.roomNumber = entity.getId();
        this.capacity = entity.getCapacity();
        this.seats = entity.getSeats();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
