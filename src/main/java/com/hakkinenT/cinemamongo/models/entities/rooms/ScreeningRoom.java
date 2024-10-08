package com.hakkinenT.cinemamongo.models.entities.rooms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hakkinenT.cinemamongo.models.entities.rooms.embedded.Seat;

@Document(collection = "rooms")
public class ScreeningRoom {
    @Id
    private Integer id;
    private Integer capacity;
    private List<Seat> seats = new ArrayList<>();
    
    public ScreeningRoom() {
    }

    public ScreeningRoom(Integer id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setSeats(List<Seat> seats){
        this.seats = seats;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScreeningRoom other = (ScreeningRoom) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}