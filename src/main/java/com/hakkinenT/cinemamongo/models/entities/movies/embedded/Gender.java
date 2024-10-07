package com.hakkinenT.cinemamongo.models.entities.movies.embedded;

public class Gender {
    private String description;

    public Gender() {
    }

    public Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}