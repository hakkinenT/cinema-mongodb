package com.hakkinenT.cinemamongo.models.entities.rooms.embedded;

public class Seat {
    private String code;

    public Seat() {
    }

    public Seat(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }  
}
