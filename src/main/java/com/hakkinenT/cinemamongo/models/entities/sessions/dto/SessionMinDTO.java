package com.hakkinenT.cinemamongo.models.entities.sessions.dto;

import com.hakkinenT.cinemamongo.models.entities.rooms.dto.ScreeningRoomMinDTO;
import com.hakkinenT.cinemamongo.models.entities.sessions.Session;
import com.hakkinenT.cinemamongo.models.entities.sessions.embedded.Price;
import com.hakkinenT.cinemamongo.utils.converters.DateConverter;

import java.time.*;

public class SessionMinDTO {
    private LocalDate exhibitionDate;
    private LocalTime exhibitionHour;
    private ScreeningRoomMinDTO room;

    private Price price;

    private boolean sessionClosed;

    public SessionMinDTO() {
    }

    public SessionMinDTO(LocalDate exhibitionDate, LocalTime exhibitionHour, Integer roomNumber, Integer capacity,Price price,
            boolean sessionClosed) {
        this.exhibitionDate = exhibitionDate;
        this.exhibitionHour = exhibitionHour;
        this.room = new ScreeningRoomMinDTO(roomNumber, capacity);
        this.price = price;
        this.sessionClosed = sessionClosed;
    }

    public SessionMinDTO(Session entity) {
        this.exhibitionDate = DateConverter.zonedDateToLocalDate(entity.getExhibitionDate());
        this.exhibitionHour = DateConverter.zonedDateToLocalTime(entity.getExhibitionDate());
        this.room = new ScreeningRoomMinDTO(entity.getRoomNumber(), entity.getCapacity());
        this.price = entity.getPrice();
        this.sessionClosed = entity.isSessionClosed();
    }

    public LocalDate getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(LocalDate exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public LocalTime getExhibitionHour() {
        return exhibitionHour;
    }

    public void setExhibitionHour(LocalTime exhibitionHour) {
        this.exhibitionHour = exhibitionHour;
    }

    public ScreeningRoomMinDTO getRoom() {
        return room;
    }

    public void setRoom(ScreeningRoomMinDTO room) {
        this.room = room;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean isSessionClosed() {
        return sessionClosed;
    }

    public void setSessionClosed(boolean sessionClosed) {
        this.sessionClosed = sessionClosed;
    }

    
    
}
