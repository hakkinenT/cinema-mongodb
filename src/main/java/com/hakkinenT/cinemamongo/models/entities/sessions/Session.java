package com.hakkinenT.cinemamongo.models.entities.sessions;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.hakkinenT.cinemamongo.models.entities.movies.Movie;
import com.hakkinenT.cinemamongo.models.entities.sessions.compositeKey.SessionPK;
import com.hakkinenT.cinemamongo.models.entities.sessions.embedded.Price;

@Document(collection = "sessions")
public class Session {

    @Id
    private SessionPK id = new SessionPK();

    private Integer capacity;

    private Price price;

    private boolean sessionClosed;

    @DocumentReference(lazy = true)
    private Movie movie;

    public Session() {
    }

    public Session(String exhibitionDate, Integer roomNumber, Integer capacity, Price price, boolean sessionClosed, Movie movie) {
        this.id.setExhibitionDate(exhibitionDate);
        this.id.setRoomNumber(roomNumber);
        this.capacity = capacity;
        this.price = price;
        this.sessionClosed = sessionClosed;
        this.movie = movie;
    }

    public String getExhibitionDate() {
        return this.id.getExhibitionDate();
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.id.setExhibitionDate(exhibitionDate);
    }

    public Integer getRoomNumber() {
        return this.id.getRoomNumber();
    }

    public void setRoomNumber(Integer roomNumber) {
        this.id.setRoomNumber(roomNumber);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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
        Session other = (Session) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}