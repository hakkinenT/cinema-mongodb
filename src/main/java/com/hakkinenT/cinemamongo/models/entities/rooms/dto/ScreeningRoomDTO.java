package com.hakkinenT.cinemamongo.models.entities.rooms.dto;

public class ScreeningRoomDTO {
    private Integer roomNumber;
    private Integer capacity;

    public ScreeningRoomDTO() {
    }

    public ScreeningRoomDTO(Integer roomNumber, Integer capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
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

    
}
