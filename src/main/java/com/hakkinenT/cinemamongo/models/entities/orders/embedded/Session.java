package com.hakkinenT.cinemamongo.models.entities.orders.embedded;

public class Session {
    private String exhibitionDate;
    private String exhibitionHour;
    private String roomNumber;
    private String movieTitle;
    
    public Session() {
    }

    public Session(String exhibitionDate, String exhibitionHour, String roomNumber, String movieTitle) {
        this.exhibitionDate = exhibitionDate;
        this.exhibitionHour = exhibitionHour;
        this.roomNumber = roomNumber;
        this.movieTitle = movieTitle;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public String getExhibitionHour() {
        return exhibitionHour;
    }

    public void setExhibitionHour(String exhibitionHour) {
        this.exhibitionHour = exhibitionHour;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
